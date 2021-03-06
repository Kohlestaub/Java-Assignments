����   < �  hausaufgaben_02/Goldpreis  java/lang/Object list Ljava/util/ArrayList; 	Signature 7Ljava/util/ArrayList<Lhausaufgaben_02/Goldtagespreis;>; <init> (Ljava/lang/String;)V 
Exceptions  java/io/FileNotFoundException Code
   	  ()V  java/util/ArrayList
  	      java/io/File
   	 
  java/util/Scanner
   	  (Ljava/io/File;)V
  ! " # nextLine ()Ljava/lang/String; % 	
 ' ) ( java/lang/String * + split ((Ljava/lang/String;I)[Ljava/lang/String; - kein Nachweis
 ' / 0 1 equals (Ljava/lang/Object;)Z��       5 hausaufgaben_02/Goldtagespreis
 4 7 	 8 (Ljava/lang/String;D)V
  : ; 1 add	 = ? > java/util/Locale @ A GERMAN Ljava/util/Locale;
 C E D java/text/NumberFormat F G getInstance ,(Ljava/util/Locale;)Ljava/text/NumberFormat;
 C I J K parse &(Ljava/lang/String;)Ljava/lang/Number;
 M O N java/lang/Number P Q doubleValue ()D
  S T U hasNextLine ()Z
  W X  close
 Z \ [ java/lang/Throwable ] ^ addSuppressed (Ljava/lang/Throwable;)V ` java/text/ParseException LineNumberTable LocalVariableTable this Lhausaufgaben_02/Goldpreis; 	dateiname Ljava/lang/String; f Ljava/io/File; sc Ljava/util/Scanner; rawData [Ljava/lang/String; preis D newEntry  Lhausaufgaben_02/Goldtagespreis; format Ljava/text/NumberFormat; number Ljava/lang/Number; e Ljava/text/ParseException; StackMapTable l printMinMax
  { | } get (I)Ljava/lang/Object;	 4  m n	 � � � java/lang/System � � out Ljava/io/PrintStream; � :eine leere Goldpreisliste enthaelt keine min und max Werte
 � � � java/io/PrintStream � 
 println
  � � � iterator ()Ljava/util/Iterator; � � � java/util/Iterator � � next ()Ljava/lang/Object; � � � U hasNext	 4 � � f datum � �Den niedrigsten Goldpreis von %.1f gab es an folgenden Tagen:
%s
Den hoechsten Goldpreis von %.1f gab es an folgenden Tagen:
%s

 � � � java/lang/Double � � valueOf (D)Ljava/lang/Double;
  � � # toString
 � � � � printf <(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream; � java/lang/Exception min max sMin sMax i I Ljava/lang/Exception; a LocalVariableTypeTable )Ljava/util/ArrayList<Ljava/lang/String;>; getPreis &(Ljava/lang/String;)Ljava/lang/String; � java/lang/StringBuilder
 � 
 � � � � append (D)Ljava/lang/StringBuilder;
 � � � java/lang/NumberFormatException � "Bitte Datum als yyyy-mm-tt angeben
 �  main ([Ljava/lang/String;)V � gold.txt
   � 
2009-10-20
  � � � � 
2009-02-07
  � y  � Datei nicht gefunden args test Ljava/io/FileNotFoundException; 
SourceFile Goldpreis.java !                 	 
          0     �*� *� Y� � � Y+� MN:� Y,� :� x�  $� &:2,� .� $ 29� 4Y2� 6:	*� 	� 9W� >� <� B:		2� H:

� L9� :	� � 4Y2� 6:	*� 	� 9W� R���� 2� V� *N� � V-�:-� 	N� -� 	-� Y-��  7 a � _ d ~ � _ ' � �    � �    a   V           '  *   7 % C & H ' W ( a ) d . l / w 0 ~ 1 � 2 � 4 � 5 �  � 8 � : b   �    � c d     � e f   � g h  ' � i j  7 h k l  H  m n  ~  m n  �  m n  W  o p 	 l  q r 	 w  s t 
 �  u v 	 � 
 o p 	 w   < � *   '  Z Z   � 9 x\ _� � T Z� 
A Z�   y     �  
  %� Y� :� Y� :6*� � z� 4� ~ 2�� *� � z� 4� ~H� ����:� ��� ��*� � z� 4� ~J*� � �:	� ;	� � � 4:� ~)�� 	� ~J� ~'�� � ~ 2�� 	� ~H	� � ���*� � �:	� 9	� � � 4:� ~'�� � �� 9W� ~)�� � �� 9W	� � ��ò ��� Y'� �SY� �SY)� �SY� �S� �W�   D D �  a   r    E  F  I + J ; K > M A H D O F Q N R O T _ W w X � Y � [ � \ � W � a � b � c � e � f � a � j � k m  j$ n b   f 
  % c d   ;  � n  O � � n  _ � � n  	 �    �    � �  F 	 u �  w , � p  � * � p  �     	 � �   � �  w   � 
�           (E �� 
        �       �  �      4 �  �       �  �       4 �  �       �    � �     �     E*� � �N� *-� � � 4M+,� �� .� � �Y� �,� ~� �� ��-� � ��ӻ �Yķ ƿ    a       x  y   z 2 x ; } b        E c d     E � f    � p  w    �    '  �  & 	 � �       _    �     3� Yɷ �L� �+̶ ζ �� �+ж ζ �+� ҧ L� �Զ ��    & )   a       � 
 �  � " � & � * � 2 � b        3 � l   
  � d  *  u �  w    i   �    �