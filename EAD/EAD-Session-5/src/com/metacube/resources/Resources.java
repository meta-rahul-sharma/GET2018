package com.metacube.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.metacube.dao.AdvertisementDao;
import com.metacube.dao.CategoryDao;
import com.metacube.entity.Advertisement;
import com.metacube.entity.Category;

/**
 * To Use data access of web services using REST
 * @author RAHUL SHARMA
 * Creation DATE: 02/08/2018
 */
@Path("resources")
public class Resources {
	
	/**
	 * To create category
	 * @param category
	 * @return response
	 */
	@POST
	@Path("createCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(@HeaderParam("authKey") String key, Category category) {
		CategoryDao categoryDao = CategoryDao.getInstance();
		
		if(getAuthorizationKey().equals(key)) {
			if(categoryDao.createCategory(category)) {
				return Response.ok("Created",MediaType.APPLICATION_JSON).build();
			} else {
				return Response.ok("NOT Created",MediaType.APPLICATION_JSON).build();
		
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}
	
	/**
	 * To get all categories
	 * @return all categories
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategory() {
		CategoryDao categoryDao = CategoryDao.getInstance();
		return categoryDao.getCategories();
	}
	
	/**
	 * To create Avertisement
	 * @param advertisement
	 * @return response
	 */
	@POST
	@Path("createAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAdvertisement(@HeaderParam("authKey") String key, Advertisement advertisement) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		if (getAuthorizationKey().equals(key)) {
			if(advertisementDao.createAdvertisement(advertisement)) {
				return Response.ok("Created",MediaType.APPLICATION_JSON).build();
			} else {
				return Response.ok("NOT Created",MediaType.APPLICATION_JSON).build();
			} 
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
		
	}
	
	/**
	 * To get all advertisements
	 * @return all advertisements
	 */
	@GET
	@Path("advertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAllAdvertisement() {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		return advertisementDao.getAdvertisements();
	}
	
	/**
	 * To get all advertisements of particular advertisement id
	 * @param categoryId
	 * @return
	 */
	@GET
	@Path("{categoryId}/advertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAllAdvertisementByCatId(@HeaderParam("authKey") String key, @PathParam("categoryId") int categoryId) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		return advertisementDao.getAdvertisementsByCategory(categoryId);
	}
	
	/**
	 * To update advertisement
	 * @param advertisement
	 * @return response
	 */
	@PUT
	@Path("updateAdvertisment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdvertisement(@HeaderParam("authKey") String key, Advertisement advertisement) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		
		if (getAuthorizationKey().equals(key)) {
			if(advertisementDao.isAdvertisementExist(advertisement.getId()) 
					&& advertisementDao.updateAdvertisementName(advertisement)) {
				return Response.ok("Updated",MediaType.APPLICATION_JSON).build();
			} else {
				return Response.ok("NOT Updated",MediaType.APPLICATION_JSON).build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}
	
	/**
	 * To update category
	 * @param category
	 * @return response
	 */
	@PUT
	@Path("updateCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(@HeaderParam("authKey") String key, Category category) {
		CategoryDao categoryDao = CategoryDao.getInstance();
		if (getAuthorizationKey().equals(key)) {
			if(categoryDao.isCategoryExist(category.getId()) 
					&& categoryDao.updateCategoryName(category)) {
				return Response.ok("Updated",MediaType.APPLICATION_JSON).build();
			} else {
				return Response.ok("NOT Updated",MediaType.APPLICATION_JSON).build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}
	
	/**
	 * To delete advertisement by its id
	 * @param advertisementId
	 * @return response
	 */
	@DELETE
	@Path("deleteAdvertisment/{advertisementId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisement(@HeaderParam("authKey") String key, @PathParam("advertisementId") int advertisementId) {
		AdvertisementDao advertisementDao = AdvertisementDao.getInstance();
		if (getAuthorizationKey().equals(key)) {
			if(advertisementDao.isAdvertisementExist(advertisementId) 
					&&advertisementDao.deleteAdvertisement(advertisementId)) {
				return Response.ok("Deleted",MediaType.APPLICATION_JSON).build();
			} else {
				return Response.ok("NOT Deleted",MediaType.APPLICATION_JSON).build();
			}
		} else {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{\"error\":\"Attribute is not defined\"}").build();
		}
		
	} 

	private Object getAuthorizationKey() {
		return "get-2018";
	}
}
