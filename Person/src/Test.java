
public class Test {
	public static void main(String[] args) {
		Person taro = new Person();
		taro.name="山田太郎";
		taro.age=20;
		taro.phoneNumber="080-1111-1111";
		taro.address="東京都";
		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);
		taro.talk();
//////////////////////////////////////////////////////
		Person jiro = new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		jiro.phoneNumber="080-2222-2222";
		jiro.address="大阪府";
		System.out.println(jiro.name);
		System.out.println(jiro.age);
		System.out.println(jiro.phoneNumber);
		System.out.println(jiro.address);
		jiro.walk();
//////////////////////////////////////////////////////
		Person hanako = new Person();
		hanako.name="鈴木花子";
		hanako.age=16;
		hanako.phoneNumber="080-3333-3333";
		hanako.address="京都府";
		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.address);
		hanako.run();

/////////////////////////////////////////////////////
	Robot aibo=new Robot();
	Robot asimo=new Robot();
	Robot pepper=new Robot();
	Robot doraemon=new Robot();

	aibo.name="アイボ";
	asimo.name="アシモ";
	pepper.name="ペッパー";
	doraemon.name="ドラえもん";

	System.out.println(aibo.name);
	System.out.println(asimo.name);
	System.out.println(pepper.name);
	System.out.println(doraemon.name);

	aibo.run();
	doraemon.talk();
	asimo.walk();
	pepper.run();

	}
}

