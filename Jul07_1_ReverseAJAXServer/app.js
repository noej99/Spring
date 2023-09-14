var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.listen(7777);
var io = require("socket.io")();
io.listen(8888);
// http://195.168.9.62:8888/socket.io/socket.io.js

io.sockets.on("connection", function(socket){
	console.log("aa");
});

app.get("/coffee.reg", function(req, res) {
	var db = require("mongojs")("195.168.9.61/xe", ["jul07_coffee"]);
	var name = req.query.n;
	var price = req.query.p;
	var coffee = {c_name : name, c_price : price};
		
	db.jul07_coffee.insert(coffee, function(err, result) {

		db.jul07_coffee.find(function(err2, result2) {
			io.sockets.emit("coffees", result2);
		});
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.send(result);
	});
});

app.get("/coffee.get", function(req, res) {
	var db = require("mongojs")("195.168.9.61/xe", ["jul07_coffee"]);
	
	db.jul07_coffee.find(function(err, result) {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.send(result);
	});
});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
