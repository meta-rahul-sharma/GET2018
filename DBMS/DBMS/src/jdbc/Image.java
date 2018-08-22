package jdbc;

/**
 * POJO for Image database which holds
 * productId and imageUrl
 * @author RAHUL SHARMA
 * CREATION DATE: 21/08/2018
 */
public class Image {
	private int productId;
	private String imageUrl;
	
	public Image(int productId, String imageUrl) {
		this.productId = productId;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
