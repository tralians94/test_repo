package in.study.java8.features;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Config {
	public static void main(String[] args) {
		/*
		 * FuncInterface funcInterface = FuncInterfaceImpl::print;
		 * funcInterface.funcInterface();
		 */
		// FuncInterfaceImpl.display(FuncInterfaceImpl::print);
		// listStreamOperations();

		SampleStudent sampleStudent = new SampleStudent();
		sampleStudent.setName("Sharon");
		sampleStudent.setRollno(18);
		sampleStudent.setStd("Btech");
		int a[] = { 23, 34, 44, 67, 67 };
		sampleStudent.setMarks(a);
		List<Integer> list = new ArrayList<Integer>();
		for (int b : a) {
			list.add(b);
		}
		list.forEach(System.out::println);
		sampleStudent.setTot(list.stream().mapToLong(i -> i).sum());
		sampleStudent.setAvg((double) (sampleStudent.getTot() / 5));
		
		SampleStudent sampleStudent1 = new SampleStudent();
		sampleStudent1.setRollno(24);
		String[] nullPropertyNames = getNullPropertyNames(sampleStudent1);
		BeanUtils.copyProperties(sampleStudent1, sampleStudent,nullPropertyNames);
		System.out.println(sampleStudent.toString());
		System.out.println(sampleStudent1.toString());
	}

	private static String[] getNullPropertyNames(Object sampleStudent1) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(sampleStudent1);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
		Set<String> set = new HashSet<String>();
		for (PropertyDescriptor pd : pds) {
			if(beanWrapper.getPropertyValue(pd.getName())==null||beanWrapper.getPropertyValue(pd.getName()).equals(0)) {
				convertNumberFormatNullsToZeroes(beanWrapper, pd);
				set.add(pd.getName());
			}
		}
		String[] emptynames = new String[set.size()];
		return set.toArray(emptynames);
	}

	private static void convertNumberFormatNullsToZeroes(BeanWrapper beanWrapper, PropertyDescriptor pd) {
		if(beanWrapper.getPropertyValue(pd.getName())==null&&(pd.getPropertyType().equals(Long.class)||pd.getPropertyType().equals(Double.class)||pd.getPropertyType().equals(Integer.class))){
			beanWrapper.setPropertyValue(pd.getName(), 0);
		}
	}

	public static void consumerMock(String a) {
		System.out.println("hi");
	}

	private static void listStreamOperations() {
		List<String> list = new ArrayList<String>();
		list.add("Sharon");
		list.add("Sharath");
		list.add("Adhil");
		list.add("Abhiram");
		list.forEach(System.out::println);// displaying all elements
		list.forEach(Config::consumerMock);
		list.stream().filter(a -> a.startsWith("a") && a.endsWith("m")).forEach(System.out::println);// displaying
																										// all
																										// elements
																										// that
																										// starts
																										// with
																										// a
																										// and
																										// ends
																										// with
																										// m
		list.stream().filter(a -> a.contains("Shar")).findFirst().ifPresent(System.out::println);// Display
																									// first
																									// elements
																									// that
																									// contains
																									// "Shar"
		list.stream().filter(a -> a.length() == 7).sorted().mapToInt(a -> a.length()).forEach(System.out::println);
		List<String> stringList = list.stream().filter(a -> a.length() > 5).map(a -> a.substring(0, 5))
				.collect(Collectors.toList());// save to list of elements having
												// size > 5
		stringList.sort(Collections.reverseOrder());// descending order sort
		stringList.stream().forEachOrdered(System.out::println);// print in
																// reverse order
		System.out.println(stringList.size());
	}
}
