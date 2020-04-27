package vo;

public class Category {
	//public int categoryId 로 사용이 가능하지만 다른 클래스에서 읽기 쓰기가 가능해져서 private로 보안걸음
	private int categoryId;
	private String categoryName;
	//getCategoryId 는 값을 가져오기에 리턴값(남아있는값)이 있음
	public int getCategoryId() {
		return categoryId;
	}
	//int categoryId로 set 값을 보낸다?
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
