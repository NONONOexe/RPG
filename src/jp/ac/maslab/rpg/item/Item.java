package jp.ac.maslab.rpg.item;

public class Item {
	private String name;
	private int price;

	public Item(String name) {
		setName(name);
		this.name = name;
		this.price = 0;
	}

	public Item(String name, int price) {
		setName(name);
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		if (name == null) {
			String errmsg = "アイテムに設定されようとしている名前が異常です:" + name;
			throw new IllegalArgumentException(errmsg);
		}
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}