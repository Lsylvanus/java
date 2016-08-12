package lsylvanus.collection_map.collection.p2_set.u2.v2;

//���������Ķ������TreeSet����������ų��ظ�,����Ҫʵ��Comparable
public class Student2_final implements Comparable {

	@Override // TreeSetʹ�ø÷����������������.
	public int compareTo(Object o) { // ʵ�ֹ���: ���ֺ�����һ����,�ų���. �Ȱ�����������,�ٰ�����������
		/*Student2_final s = (Student2_final) o;
		if (this.age == s.age && this.name.equals(s.name)) {
			return 0;
		} else if (this.name.equals(s.name)) {
			return this.age - s.age; // ��������
			// return s.age-this.age; //���併��
		} else {
			return this.name.compareTo(s.name); // ��������
		}*/
		return 0;
	}

	@Override // ������������hashCode��ͬ,���ǿ��Զ϶���������ͬ.
				// ������������hashCode��ͬ,������������ͬ,���ܲ�ͬ,��Ҫ����equals�����ж�
	public int hashCode() {
		System.out.println(id + " : hashCode");
		// �����������������ж����������Ƿ���ͬ���߲�ͬ, ����Ҫͨ�����ֺ��������hashCode
		return age + name.hashCode();
	}

	@Override // equals��������hashCode��ͬ�������,�ٶ����ݽ��бȽϵķ���.hashCode��ͬ&&equals�������ʱ��,����Ϊ����������ͬ.
	public boolean equals(Object obj) {
		System.out.println(this.id + " equals " + ((Student2_final) obj).getId());
		// return super.equals(obj);
		// ͨ�����������������hashCode�����϶��Ƕ���ͬ,��ô��Ҫʹ����ͬ���������ж����������Ƿ���ͬ.
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
