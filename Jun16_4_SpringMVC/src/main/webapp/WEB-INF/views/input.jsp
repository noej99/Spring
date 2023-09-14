<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/uc.css">
<script type="text/javascript" src="resources/js/noejValidChecker.js"></script>
<script type="text/javascript" src="ucCheck.js"></script>
<script type="text/javascript">
	// var s = "1 * 2 * 3 * 4 * 5";
	// alert(s);
	// alert(eval(s));
</script>
</head>
<body>
	<form action="unit.convert" name="ucForm" onsubmit="return check();">
		<table>
			<tr>
				<th>단위변환</th>
			</tr>
			<tr>
				<td align="center"><input name="from" placeholder="숫자"
					autofocus="autofocus"></td>
			</tr>
			<tr>
				<td align="center"><select name="what">
						<option value="len">cm → inch</option>
						<option value="size">㎡ → 평</option>
						<option value="temp">℃ → ℉</option>
						<option value="spd">km/h → mi/h</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">
					<button>변환</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>