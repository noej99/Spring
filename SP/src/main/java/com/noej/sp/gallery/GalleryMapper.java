package com.noej.sp.gallery;

import java.util.List;

public interface GalleryMapper {
	public abstract int delete(Gallery g);
	public abstract int write(Gallery g);
	public abstract List<Gallery> get();
	public abstract String getImg(Gallery g);
}
