????   < C  hausaufgaben_02/Test  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lhausaufgaben_02/Test; main ([Ljava/lang/String;)V 
Exceptions  java/text/ParseException  	22.580,00	    java/util/Locale   GERMAN Ljava/util/Locale;
    java/text/NumberFormat    getInstance ,(Ljava/util/Locale;)Ljava/text/NumberFormat;
  " # $ parse &(Ljava/lang/String;)Ljava/lang/Number;
 & ( ' java/lang/Number ) * doubleValue ()D	 , . - java/lang/System / 0 out Ljava/io/PrintStream;
 2 4 3 java/io/PrintStream 5 6 println (D)V args [Ljava/lang/String; s1 Ljava/lang/String; format Ljava/text/NumberFormat; number Ljava/lang/Number; d1 D 
SourceFile 	Test.java !               /     *? ?    
                    	             ?     L? ? M,+? !N-? %9? +? 1?    
       	  
 
           4     7 8     9 :  
  ; <    = >   	 ? @   A    B