/* An animal shelter, which holds only dogs and cats, operates on a strictly
"first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of
all animals at the shelter, or they can select whether they would
prefer a dog or a cat (and will receive the oldest animal of that type).
They cannot select which specific animal they would like.
Create the data structures to maintain this system and implement
operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
*/

abstract class Animal {
	private int order;
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}

class AnimalQueueArray<T extends Animal> {
	private Animal[] arr;
	private int front;
	private int back;
	private int size;
	private int numItems;

	public AnimalQueueArray(int size) {
		this.arr = new Animal[size];
		this.front = 0;
		this.back = -1;
		this.size = size;
		this.numItems = 0;
	}

	public boolean isFull() {
		return numItems == size;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void enqueue(T animal) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		back = (back + 1) % size;
		arr[back] = animal;
		numItems++;
	}

	public T dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		T animal = (T) arr[front];
		front = (front + 1) % size;
		numItems--;
		return animal;
	}

	public T peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return (T) arr[front];
	}
}

class AnimalShelter {
	private AnimalQueueArray<Dog> dogs;
	private AnimalQueueArray<Cat> cats;
	private int order;

	public AnimalShelter(int size) {
		dogs = new AnimalQueueArray<>(size);
		cats = new AnimalQueueArray<>(size);
		order = 0;
	}

	public void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;

		if (animal instanceof Dog) {
			dogs.enqueue((Dog) animal);
		} else if (animal instanceof Cat) {
			cats.enqueue((Cat) animal);
		}
	}

	public Animal dequeueAny() {
		if (dogs.isEmpty()) {
			return dequeueCat();
		} else if (cats.isEmpty()) {
			return dequeueDog();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}

	public Dog dequeueDog() {
		return dogs.dequeue();
	}

	public Cat dequeueCat() {
		return cats.dequeue();
	}

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter(5);

        animalShelter.enqueue(new Dog("Billy"));
        animalShelter.enqueue(new Cat("ChickenNugget"));
        animalShelter.enqueue(new Dog("Geo"));
        animalShelter.enqueue(new Cat("Chris"));
        animalShelter.enqueue(new Dog("Jimmy"));

        System.out.println(animalShelter.dequeueAny().name);
        System.out.println(animalShelter.dequeueDog().name);
        System.out.println(animalShelter.dequeueCat().name);
    }
}