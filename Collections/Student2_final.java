package lsylvanus.collection_map.collection.p2_set.u2.v2;

//如果想让类的对象放入TreeSet中排序或者排除重复,必须要实现Comparable
public class Student2_final implements Comparable {

	@Override // TreeSet使用该方法进行排序和排重.
	public int compareTo(Object o) { // 实现规则: 名字和年龄一样的,排除掉. 先按照名字排序,再按照年龄排序
		/*Student2_final s = (Student2_final) o;
		if (this.age == s.age && this.name.equals(s.name)) {
			return 0;
		} else if (this.name.equals(s.name)) {
			return this.age - s.age; // 年龄升序
			// return s.age-this.age; //年龄降序
		} else {
			return this.name.compareTo(s.name); // 名字升序
		}*/
		return 0;
	}

	@Override // 如果两个对象的hashCode不同,我们可以断定两个对象不同.
				// 如果两个对象的hashCode相同,这个对象可能相同,可能不同,需要调用equals再做判断
	public int hashCode() {
		System.out.println(id + " : hashCode");
		// 按照姓名和年龄来判断两个对象是否相同或者不同, 就需要通过名字和年龄算出hashCode
		return age + name.hashCode();
	}

	@Override // equals方法是在hashCode相同的情况下,再对内容进行比较的方法.hashCode相同&&equals返回真的时候,才认为两个对象相同.
	public boolean equals(Object obj) {
		System.out.println(this.id + " equals " + ((Student2_final) obj).getId());
		// return super.equals(obj);
		// 通过姓名和年龄算出的hashCode用来断定是都不同,那么就要使用相同的属性来判定两个对象是否相同.
		if (obj == null)
			return false;
		if (obj instanceof Student2_final) {
			Student2_final s = (Student2_final) obj;
			return this.age == s.age && this.name.equals(s.name);
		}
		return false;
	}

	private int id;
	private String name;
	private int age;

	public Student2_final(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
