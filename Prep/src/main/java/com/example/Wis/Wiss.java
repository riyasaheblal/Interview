package com.example.Wis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wiss {
	static int N=10;
	static int count=1;
	static Object lock=new Object();
public static void main(String[] args) {
//	studCSV();
	
//	for (int i = 1; i <=3; i++) {
//		int tid=i;
//		new Thread(()->{
//			while(true) {
//				synchronized (lock) {
//					if(count>N) break;
//					if((count-1)%3+1==tid) {
//						System.out.println("Thread:"+tid+"::"+count++);
//					}
//				}
//			}
//		}).start();		
//	}
	
//	studDat();
	
// tre();
	
//sortlenght();
	
//	treeMap();
	
	slidwin();
	
//	ologn();
	
//	NOB();
	
//	compress();
	
//	obj();
	
//	pali();
	
	//largestnum();
}

private static void largestnum() {
	int[] num = {3, 30, 34, 5, 9};	
	String[] arr = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
Arrays.sort(arr,(a,b)-> (b+a).compareTo(a+b));
String join = String.join("", arr);
System.out.println(join.startsWith("0")? "0":join);
}

private static void pali() {
	String s="malayalam";
	Map<Character, Long> collect = s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	long count2 = collect.values().stream().filter(n-> n%2!=0).count();
	System.out.println(count2<=1);
	List<String> li = Arrays.asList("malayalam","tabat","bat");
	List<String> collect2 = li.stream().filter(n-> n.equals(new StringBuilder(n).reverse().toString())).map(n-> n).collect(Collectors.toList());
System.out.println(collect2);
List<Integer> in = Arrays.asList(1,2,10,32,33,43,20);
List<Integer> collect3 = in.stream().filter(n-> n>10 && n%2==0).map(n->n).collect(Collectors.toList());
System.out.println(collect3);
}

private static void obj() {
Object[] ob= {1,2, "hello",new Object[] {3,4,"Dell"},5,new Object[] {6}};
ArrayList<Integer> li = new ArrayList<>();
ArrayList<String> li2 = new ArrayList<>();
flatten(ob,li,li2);
System.out.println(li+" "+li2);
}

private static void flatten(Object[] ob, ArrayList<Integer> li, ArrayList<String> li2) {
for(Object obj:ob) {
	if(obj instanceof Integer) {
		li.add((Integer) obj);
	}else if(obj instanceof String) {
		li2.add((String) obj);
	}
	else if(obj instanceof Object) {
		flatten((Object[])obj, li,li2);
	}
}
}

private static void compress() {
int[] c= {1, 3, 11, 5, 2};
PriorityQueue<Integer> pq=new PriorityQueue<>();
for(int i:c) pq.add(i);

int total=0;
while(pq.size()>1) {
	System.out.println(pq);
	int a = pq.poll();
	int b = pq.poll();
	int sum=a+b;
	total+=sum;
	System.out.println(total);
	pq.add(sum);
}
System.out.println(total);
}

private static void NOB() {

	String s="90101";
	boolean b = s.chars().allMatch(c-> c=='0' || c=='1');
	boolean o = s.chars().allMatch(c-> c>='0' && c<='7');
	if(b) System.out.println("binary");
	else if(o) System.out.println("Octal");
	else System.out.println("Number");
} 

private static void ologn() {
int[] num= {4,5,6,7,2,3};
int left=0, n=num.length, right=n-1;
while(left<right) {
	int mid=(left+right)/2;
	if(num[mid]>num[right]) {
		left=mid+1;
	}else {
		right=mid;
	}
	
	
}
int p=left;
System.out.println(num[p+1]%n);

}

private static void slidwin() {
String s="bbbbb";
int left=0, max=0;
Set<Character> seen=new HashSet<>();
//count dist cha//4
//for (int i = 0; i < s.length(); i++) {
//	if(!seen.add(s.charAt(i))) {
//		seen.add(s.charAt(left++));
//	}
//	max=Math.max(max, i-left+1);
//}

//count remove left remain 2//3
int k=2;
Map<Character, Integer> map=new HashMap<>();

for (int i = 0; i < s.length(); i++) {
	char c1 = s.charAt(i);
	map.put(c1, map.getOrDefault(c1, 0)+1);
	if(map.size()>k) {
		char c2 = s.charAt(left);
		map.put(c2, map.get(c1)-1);
		if(map.get(c2)==0) {
			map.remove(c2);
		}
		left++;
	}
	max=Math.max(max, i-left+1);
}

System.out.println(max);
}

private static void treeMap() {
	TreeMap<Integer, Integer> t1=new TreeMap<>();
	t1.put(1, 20);
	t1.put(2, 10);
	t1.put(3, 20);
	TreeMap<Integer, Integer> t2=new TreeMap<>();
	t2.put(2, 20);
	t2.put(3, 10);
	t2.put(4, 20);
	TreeMap<Integer, Integer> t3=new TreeMap<>(t2);
	for(Entry<Integer, Integer> p:t1.entrySet()) {
		t3.merge(p.getKey(), p.getValue(), Integer::sum);
	}
	System.out.println(t3);
}

private static void sortlenght() {
String s="Java is a amazing";
String collect = Arrays.stream(s.split("\\s+")).sorted(Comparator.comparing(String::length)).map(n-> n).collect(Collectors.joining(" "));
System.out.println(collect);
}

private static void tre() {
String s="trree";  //eetr //trree//rreet
LinkedHashMap<Character, Long> freq = s.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
System.out.println(freq);
List<Character> collect = freq.entrySet().stream().sorted((a,b)-> b.getValue().compareTo(a.getValue())).map(n-> n.getKey()).collect(Collectors.toList());
System.out.println(collect);
StringBuilder s1=new StringBuilder();
for(Character c:collect) {
	System.out.println(freq.get(c));
	s1.append(String.valueOf(c).repeat(freq.get(c).intValue()));
}
System.out.println(s1);
}

private static void studDat() {

	String[][] data = {
		    {"Rama", "Math", "50"},
		    {"Rama", "Physics", "60"},
		    {"Rama", "English", "45"},
		    {"Hari", "Math", "70"},
		    {"Hari", "Physics", "65"},
		    {"Hari", "English", "85"},
		    {"Gita", "Math", "90"},
		    {"Gita", "Physics", "55"},
		    {"Gita", "English", "80"}
		};

	Map<String, Integer> map=new HashMap<>();
	//collect data
	for(String[] r:data) {
		String name = r[0];
		int marks = Integer.parseInt(r[2]);
		map.put(name, map.getOrDefault(name, 0)+marks);
	}
	//sort
	ArrayList<Entry<String, Integer>> sl = new ArrayList<>(map.entrySet());
	sl.sort((a,b)-> b.getValue().compareTo(a.getValue()));
	for(Entry<String, Integer> a:sl) {
		System.out.println(a);
	}
	
	
}

private static void studCSV() {
//	1, Bob, 2020-01-05
//	2, Alice, 2020-01-31
	ArrayList<Object> li = new ArrayList<>();
try(BufferedReader br=new BufferedReader(new FileReader(""))){
	br.readLine();
	String line;
	while((line=br.readLine())!=null) {
		String[] split = line.split(",");
		int id = Integer.parseInt(split[0]);
		String name = split[1];
		LocalDate localDate = LocalDate.parse(split[2]);
//		Student s=new Student(id,name,localDate);
//		li.add(student);
	}
	System.out.println(li);
	
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
