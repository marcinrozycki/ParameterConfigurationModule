package pl.pcm.model;

public abstract class Parameter {

	protected String name;
	protected String description;
	protected String category;
	protected String type;

	public String getName() {
		return name;
	};

	public void setName(String name) {
		this.name = name;
	};

	public String getDescription() {
		return description;
	};

	public void setDescription(String description) {
		this.description = description;
	};

	public String getCategory() {
		return category;
	};

	public void setCategory(String category) {
		this.category = category;
	};

	public String getType() {
		return type;
	};

	public abstract Object getValue();

	public abstract void setValue(Object value);

	@Override
	public String toString(){
		return "Name: " + name + " Description: " + description + " Type: " + type + " Category: " + category + " value: "+ getValue();
	} 

}
