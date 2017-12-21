package capsule;

public class Person {

	private String name=null;
	private int age=0;
	private String address="aaa@co.jp";

	///////////////////////////////////////////////////////コンストラクタ（オーバーロード）
	public Person(){
		System.out.println("プロフィールが表示できません");
		System.out.println("引数を入力してください");
	}

	public Person(String name){
		setName(name);
		System.out.println(name);
	}

	public Person(String name,int age){
		this(name);
		setAge(age);
		System.out.println(age);
	}

	public Person(String name,int age,String address){
		this(name,age);
		setAddress(address);
		System.out.println(address);
	}

/////////////////////////////////////////////////////////ゲッターとセッター
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}
////////////////////////////////////////

}