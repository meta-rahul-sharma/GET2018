package com.metacube.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.dao.AdvertisementDao;
import com.metacube.dao.CategoryDao;
import com.metacube.entity.Advertisement;
import com.metacube.entity.Category;

@Path("resources")
public class Resources {
	
	@POST
	@Path("createCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean createCategory(Category category) {
		CategoryDao categoryDao = CategoryDao.getInstance();
		return categoryDao.createCategory(category);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategory() {
		CategoryDao categoryDao = CategoryDao.getInstance();
		return categoryDao.getCategories();
	}
	
	@POST
	@Path("createAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean createAdvertisement(Advertisement advertisement) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		return advertisementDao.createAdvertisement(advertisement);
	}
	
	@GET
	@Path("advertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAllAdvertisement() {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		return advertisementDao.getAdvertisements();
	}
	
	@GET
	@Path("{categoryId}/advertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAllAdvertisementByCatId(@PathParam("categoryId") int categoryId) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		return advertisementDao.getAdvertisementsByCategory(categoryId);
	}
	
	@PUT
	@Path("updateAdvertisment")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateAdvertisement(Advertisement advertisement) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		if(advertisementDao.isAdvertisementExist(advertisement.getId())) {
			return advertisementDao.updateAdvertisementName(advertisement); 
		}
		
		return false;
	}
	
	@PUT
	@Path("updateCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateCategory(Category category) {
		CategoryDao categoryDao = CategoryDao.getInstance();
		if(categoryDao.isCategoryExist(category.getId())) {
			return categoryDao.updateCategoryName(category); 
		}
		
		return false;
	}
	
	@DELETE
	@Path("deleteAdvertisment/{advertisementId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteAdvertisement(@PathParam("advertisementId") int advertisementId) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		if(advertisementDao.isAdvertisementExist(advertisementId)) {
			return advertisementDao.deleteAdvertisement(advertisementId); 
		}
		return false;
	}
}
