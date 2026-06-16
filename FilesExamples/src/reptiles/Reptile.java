package reptiles;

public class Reptile implements Comparable<Reptile>{

	private int id, age, length;
	  private String zoo;
	  
	  
	  public Reptile() {
			super();
			this.id = -1;
			this.age = 0;
			this.length = 5;
			this.zoo = "Selva Magica";
		}
	  
		public Reptile(int id, int age, int length, String zoo) {
			super();
			this.id = id;
			this.age = age;
			this.length = length;
			this.zoo = zoo;

		}
		public int getId() {
			return id;
		
		}
		public int setId(int id) throws InvalidNumberException {
			if (id<0) {
				throw new InvalidNumberException();
			}else {
			  this.id = id;
			  return id;
			}
		
		}
		public int getAge() {
			return age;
		
		}

		public int setAge(int age) throws InvalidNumberException{
			if (age<0) {
				throw new InvalidNumberException();
			}else {
			  this.age = age;
			  return age;
			}
		
		}
		public int getLength() {
			return length;
		
		}
		
		public int setLength(int length) throws InvalidNumberException {
			if (length<0) {
				throw new InvalidNumberException();
			}else {
			  this.length = length;
			  return length;
			}
		}
		public String getZoo() {
			return zoo;
		
		}
		public void setZoo(String zoo) {
			this.zoo = zoo;
		
		}
		
		@Override
		public String toString() {
			return "id=" + id + ", age=" + age + ", length=" + length + ", zoo=" + zoo +" ";

		}

		@Override
		public int compareTo(Reptile o) {
			int aux;
			aux=this.id-((Reptile) o).getId();
			return aux;
		}

		@Override
		public boolean equals(Object obj) {
			int aux;
			aux=this.id-((Reptile)obj).getId();
			if(aux==0)
				return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.id;
		}
}
