package ExamPreparation;

public class Demo {
    /*
    Стек (Stack)
•	LIFO (Last In, First Out)
•	Последният поставен елемент, излиза първи
•	Визуализация: под формата на купчина книги
•	Основни методи:
o	push (елемент): добавя елемент на върха на стека
o	pop(): премахва и връща елемента от върха на стека
o	peek(): връща елементът, който е на върха на стека, но не го премахва
o	size(): връща цяло число, което показва колко е размерът на стека (броят на елементите)
o	isEmpty(): връща true, ако е празен стекът и връща false, ако стекът има поне един или повече елементи
o	contains(елемент): връща true, ако елементът е наличен в стека и връща false, ако елементът го няма в стека

•	Примерен код:
o	Създаване на стек:

ArrayDeque<Integer> stack = new ArrayDeque<>();

o	Добавяне на данни в стек от конзолата:

Arrays.stream(scanner. nextLine().split("\\s+"))
.map(Integer::parseInt).forEach(stack::push);

o	Отпечатване на данни от стек на конзолата:

stack.stream().map(String::valueOf)
.collect(Collectors.joining(", "));

o	Допълнителни операции:

ArrayDeque<Integer> stack = new ArrayDeque<>();
stack.push(2);
stack.push(3);
stack.push(5);
stack.push(13);

System.out.println(stack.peek()); //13

int lastElement = stack.pop(); //13
System.out.println(lastElement);

System.out.println(stack.size()); //3
System.out.println(stack.contains(3)); //true
System.out.println(stack.contains(32)); //false
System.out.println(stack.isEmpty()); //false

stack.forEach(System.out::println);

•	Особености при работа със стек:
o	Винаги проверявайте при pop дали има елементи в стека
o	Често се използва в случаи, в които трябва да вземем последния въведен елемент



Опашка (Queue)
•	FIFO (First In, First Out)
•	Първият добавен елемент, излиза първи
•	Визуализация: под формата на опашка в магазин
•	Основни методи:
o	add (елемент): добавя елемент на края на опашката, хвърля exception при пълна опашка
o	offer (елемент): добавя елемент на края на опашката, връща null при пълна опашка

o	poll(): премахва и връща елемента от края на опашката, връща null при празна опашка
o	remove(): премахва и връща елемента от края на опашката, хвърля exception при празна опашка

o	peek(): връща елементът, който е в края на опашката, но не го премахва

o	size(): връща цяло число, което показва колко е размерът на опашката (броят на елементите)
o	isEmpty(): връща true, ако е празна опашката и връща false, ако опашката има поне един или повече елементи
o	contains(елемент): връща true, ако елементът е наличен в опашката и връща false, ако елементът го няма в опашката
•	Примерен код:
o	Създаване на опашка:
ArrayDeque<Integer> queue = new ArrayDeque<>();

o	Добавяне на данни в стек от конзолата:
ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
.map(Integer::parseInt)            .collect(Collectors.toCollection(ArrayDeque::new));

o	Отпечатване на данни от опашка на конзолата:
queue.stream().map(String::valueOf)
.collect(Collectors.joining(", "));

o	Допълнителни операции:
ArrayDeque<Integer> queue = new ArrayDeque<>();
queue.add(2);
queue.offer(3);
queue.add(5);
queue.offer(13);

System.out.println(queue.peek()); //13

int lastElement = queue.remove(); //13
System.out.println(lastElement);

System.out.println(queue.size()); //2
System.out.println(queue.contains(3)); //true
System.out.println(queue.contains(32)); //false
System.out.println(queue.isEmpty()); //false

queue.forEach(System.out::println);



Речници (Maps)
•	Видове:
o	HashMap – не е гарантирана подредбата на записите
o	LinkedHashMap – редът на записите се запазва спрямо реда на добавяне
o	TreeMap – записите се сортират спрямо стойностите на ключовете в ascending order
•	Сортировки:
o	Sorting map by value (list count)
Map<String, List<String>> map = new HashMap<>();
        map
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(pair -> {
                    System.out.println(pair.getKey());
                    pair.getValue().forEach(el -> System.out.println(el));
                });

•	Sorting map by key ascending
map
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                HashMap::new));
•	Sorting map by value ascending
map
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

•	Sorting map by key descending
map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByKey()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                HashMap::new));

•	Sorting map by value descending
map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));





•	Отпечатване:
o	Чрез stream

map.entrySet().stream().forEach(entry -> {
System.out.println(entry.getKey());	                               System.out.println(entry.getValue());
   });


o	Чрез foreach


map.forEach((key, value) -> {
            System.out.println(key);
                        System.out.println(value);
});

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	System.out.println(entry.getKey());
System.out.println(entry.getValue());
}

Матрици (Multidimensional Arrays)
•	Създаване на празна матрица
o	Цели числа: int[][] matrix = new int[rows][cols];
o	Дробни числа: double[][] matrix = new double[rows][cols];
o	Текстове: String[][] matrix = new String[rows][cols];
o	Символи: char[][] matrix = new char[rows][cols];
•	Движения в матрица
o	Долу: ред + 1
o	Горе: ред – 1
o	Ляво: колона – 1
o	Дясно: колона + 1


•	Валидиране на позиция в матрица
ред >= 0 && ред < брой редове && колона >= 0 && колона < брой колони
•	Прочитане на матрица от конзолата:
o	Цели числа

private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

o	Дробни числа

private static void fillMatrix(double[][] matrix, Scanner s) {
    for (int row = 0; row < matrix.length ; row++) {
        for (int col = 0; col < matrix.length; col++) {
            matrix[row][col] = s.nextDouble();
        }
    }
}

o	Символи

private static void fillMatrix(char[][] matrix, Scanner s) {
   for (int row = 0; row < matrix.length ; row++) {
	     	char[] rowData = scanner.nextLine().toCharArray();
     	matrix[row] = rowData;
  }
}
o	Текстове

private static void fillMatrix(String[][] matrix, Scanner s) {
     for (int row = 0; row < matrix.length; row++) {
       matrix[row] = scanner.nextLine().split("");
    }
}
•	Отпечатване на матрица от конзолата:
  - вложен фор
private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
         for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
         }
            System.out.println();
      }
  }

   - foreach
private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

     */
}
