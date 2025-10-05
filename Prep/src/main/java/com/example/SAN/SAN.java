package com.example.SAN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SAN {
public static void main(String[] args) {
//	bra();
//	addmul();
//	reve();
//	IntStream.rangeClosed(1, 30).filter(SAN::isprime).forEach(System.out::println);
// ana();
//fibbo();
	arr();
//	str();
}


private static void str() {
String s="Riyaaaa Gupta Gupta Riya Riya a";
String w="R i  y a";
long count = Arrays.stream(w.split("\\s+")).count();
long count2 = s.chars().mapToObj(c-> (char) c).count();
System.out.println(count+" "+count2);
String collect3 = Arrays.stream(w.split("\\s+")).collect(Collectors.joining(""));
Map<String, Long> collect2 = Arrays.stream(s.split("\\s+")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
Map<Character, Long> collect = s.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
System.out.println(collect+" "+collect2);
collect.entrySet().stream().filter(n-> n.getValue()==1).map(n-> n.getKey()).limit(1).forEach(System.out::println);
collect2.entrySet().stream().filter(n-> n.getValue()>1).map(n-> n.getKey()+ "= "+n.getValue()).forEach(System.out::println);
collect.entrySet().stream().filter(n-> n.getKey()==' ').map(n-> n.getValue()).forEach(System.out::println);
System.out.println(collect3);
String orElse = Arrays.stream(s.split("\\s+")).max(Comparator.comparing(String::length)).orElse(null);
System.out.println(orElse);
}


private static void arr() {
	List<String> ls = Arrays.asList("silent","10","90.0","tab","hat");
List<Integer> li = Arrays.asList(1,2,32,1,3,13,3);
List<Integer> li2 = Arrays.asList(1,2,32,1,3,13,3);
List<Integer> li3 = new ArrayList<>(li2);
li3.addAll(li);
//System.out.println(li.equals(li2)+ " "+li3);
//
//List<String> collect = ls.stream().collect(Collectors.toList());
//System.out.println(collect);
//Collections.sort(ls);
li.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(3).forEach(System.out::println);
//Map<Integer, Long> fre = li.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//System.out.println(fre+" "+ls);
//fre.entrySet().stream().filter(n-> n.getValue()>1).map(n-> n.getKey()).limit(1).forEach(System.out::println);
//List<String> collect2 = ls.stream().filter(x-> {
//try {
//	Double.parseDouble(x);
////	Integer.parseInt(x);
////	return false;
//	return x.contains(".");
////	return true;
//}catch (Exception e) {
//	return false;
//}
//}).collect(Collectors.toList());
//
//System.out.println(collect2);
}


private static void fibbo() {
int n=10;
Stream.iterate(new int[] {0,1} , f-> new int[] {f[1],f[0]+f[1]}).limit(n).map(f-> f[0]).forEach(System.out::println);
IntStream.rangeClosed(1, 30).forEach(System.out::println);
}


private static void ana() {
	List<String> li = Arrays.asList("silent","lisent","bat","tab","hat");
	Map<String, List<String>> map=new HashMap<>();
	for(String s:li) {
		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		String s1=new String(c1);
		map.computeIfAbsent(s1, n-> new ArrayList<>()).add(s);
	}
	System.out.println(map.values());
	
	String q="bat";
	String q1="tab";
	char[] w1 = q.toLowerCase().toCharArray();
	char[] w2 = q1.toLowerCase().toCharArray();
	Arrays.sort(w1);
	Arrays.sort(w2);
	String s=new String(w1);
	System.out.println(Arrays.equals(w1, w2)+ " "+s);
}


public static boolean isprime(int num) {
	if(num<=1)return false;
	return IntStream.rangeClosed(2,(int) Math.sqrt(num)).noneMatch(i->num%i==0);
}

private static void reve() {
List<String> li = Arrays.asList("riya","hello");
String s="Riya Gupta";
int i=101;
Collections.reverse(li);
String i1 = String.valueOf(i);
String i2 = new StringBuilder(String.valueOf(s)).reverse().toString();
System.out.println(s.equals(i2)+" "+li);
String collect = Arrays.stream(s.split("\\s+")).map(n-> new StringBuilder(n).reverse().toString()).collect(Collectors.joining(" "));
System.out.println(collect);
}

private static void addmul() {
int[] i= {1,3,23,4};
int sum = Arrays.stream(i).reduce(0,(a,b)-> a+b);
int mul = IntStream.rangeClosed(1, 30).reduce(1,(a,b)-> a*b);
}

private static void bra() {
String b="()()()";
int start=0,count=0;
ArrayList<Object> li = new ArrayList<>();
for (int i = 0; i < b.length(); i++) {
	if(b.charAt(i)=='(') count++;
	else if(b.charAt(i)==')') count--;
	if(count==0) {
		li.add(b.substring(start,i+1));
		start=i+1;
	}
}
System.out.println(li);
String s="Riya~Gupta";
String[] split = s.split("~");
System.out.println(split[0] + " "+split[1]);


String q="12p4a3w2an4k3a32l3e%%";
StringBuilder d = new StringBuilder();
StringBuilder l = new StringBuilder();
StringBuilder n = new StringBuilder();
for (int i = 0; i < q.length(); i++) {
	if(Character.isLetter(q.charAt(i))) {
		l.append(q.charAt(i));
	}
	else if(Character.isDigit(q.charAt(i))) {
		d.append(q.charAt(i));
	}
	else {
		n.append(q.charAt(i));
	}
	
}
System.out.println(d+" "+n+" "+l);

}

}
