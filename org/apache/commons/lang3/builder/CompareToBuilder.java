/*      */ package org.apache.commons.lang3.builder;
/*      */ 
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Objects;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CompareToBuilder
/*      */   implements Builder<Integer>
/*      */ {
/*  112 */   private int comparison = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2) {
/*  143 */     return reflectionCompare(paramObject1, paramObject2, false, null, new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  175 */     return reflectionCompare(paramObject1, paramObject2, paramBoolean, null, new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, Collection<String> paramCollection) {
/*  208 */     return reflectionCompare(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, String... paramVarArgs) {
/*  241 */     return reflectionCompare(paramObject1, paramObject2, false, null, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass, String... paramVarArgs) {
/*  283 */     if (paramObject1 == paramObject2) {
/*  284 */       return 0;
/*      */     }
/*  286 */     Objects.requireNonNull(paramObject1, "lhs");
/*  287 */     Objects.requireNonNull(paramObject2, "rhs");
/*      */     
/*  289 */     Class<?> clazz = paramObject1.getClass();
/*  290 */     if (!clazz.isInstance(paramObject2)) {
/*  291 */       throw new ClassCastException();
/*      */     }
/*  293 */     CompareToBuilder compareToBuilder = new CompareToBuilder();
/*  294 */     reflectionAppend(paramObject1, paramObject2, clazz, compareToBuilder, paramBoolean, paramVarArgs);
/*  295 */     while (clazz.getSuperclass() != null && clazz != paramClass) {
/*  296 */       clazz = clazz.getSuperclass();
/*  297 */       reflectionAppend(paramObject1, paramObject2, clazz, compareToBuilder, paramBoolean, paramVarArgs);
/*      */     } 
/*  299 */     return compareToBuilder.toComparison();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void reflectionAppend(Object paramObject1, Object paramObject2, Class<?> paramClass, CompareToBuilder paramCompareToBuilder, boolean paramBoolean, String[] paramArrayOfString) {
/*  321 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/*  322 */     AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/*  323 */     for (byte b = 0; b < arrayOfField.length && paramCompareToBuilder.comparison == 0; b++) {
/*  324 */       Field field = arrayOfField[b];
/*  325 */       if (!ArrayUtils.contains((Object[])paramArrayOfString, field.getName()) && 
/*  326 */         !field.getName().contains("$") && (paramBoolean || 
/*  327 */         !Modifier.isTransient(field.getModifiers())) && 
/*  328 */         !Modifier.isStatic(field.getModifiers())) {
/*      */         try {
/*  330 */           paramCompareToBuilder.append(field.get(paramObject1), field.get(paramObject2));
/*  331 */         } catch (IllegalAccessException illegalAccessException) {
/*      */ 
/*      */           
/*  334 */           throw new InternalError("Unexpected IllegalAccessException");
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder appendSuper(int paramInt) {
/*  350 */     if (this.comparison != 0) {
/*  351 */       return this;
/*      */     }
/*  353 */     this.comparison = paramInt;
/*  354 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object paramObject1, Object paramObject2) {
/*  378 */     return append(paramObject1, paramObject2, (Comparator<?>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object paramObject1, Object paramObject2, Comparator<?> paramComparator) {
/*  407 */     if (this.comparison != 0) {
/*  408 */       return this;
/*      */     }
/*  410 */     if (paramObject1 == paramObject2) {
/*  411 */       return this;
/*      */     }
/*  413 */     if (paramObject1 == null) {
/*  414 */       this.comparison = -1;
/*  415 */       return this;
/*      */     } 
/*  417 */     if (paramObject2 == null) {
/*  418 */       this.comparison = 1;
/*  419 */       return this;
/*      */     } 
/*  421 */     if (paramObject1.getClass().isArray()) {
/*      */       
/*  423 */       appendArray(paramObject1, paramObject2, paramComparator);
/*      */     
/*      */     }
/*  426 */     else if (paramComparator == null) {
/*      */       
/*  428 */       Comparable<Object> comparable = (Comparable)paramObject1;
/*  429 */       this.comparison = comparable.compareTo(paramObject2);
/*      */     } else {
/*      */       
/*  432 */       Comparator<?> comparator = paramComparator;
/*  433 */       this.comparison = comparator.compare(paramObject1, paramObject2);
/*      */     } 
/*      */     
/*  436 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void appendArray(Object paramObject1, Object paramObject2, Comparator<?> paramComparator) {
/*  443 */     if (paramObject1 instanceof long[]) {
/*  444 */       append((long[])paramObject1, (long[])paramObject2);
/*  445 */     } else if (paramObject1 instanceof int[]) {
/*  446 */       append((int[])paramObject1, (int[])paramObject2);
/*  447 */     } else if (paramObject1 instanceof short[]) {
/*  448 */       append((short[])paramObject1, (short[])paramObject2);
/*  449 */     } else if (paramObject1 instanceof char[]) {
/*  450 */       append((char[])paramObject1, (char[])paramObject2);
/*  451 */     } else if (paramObject1 instanceof byte[]) {
/*  452 */       append((byte[])paramObject1, (byte[])paramObject2);
/*  453 */     } else if (paramObject1 instanceof double[]) {
/*  454 */       append((double[])paramObject1, (double[])paramObject2);
/*  455 */     } else if (paramObject1 instanceof float[]) {
/*  456 */       append((float[])paramObject1, (float[])paramObject2);
/*  457 */     } else if (paramObject1 instanceof boolean[]) {
/*  458 */       append((boolean[])paramObject1, (boolean[])paramObject2);
/*      */     }
/*      */     else {
/*      */       
/*  462 */       append((Object[])paramObject1, (Object[])paramObject2, paramComparator);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long paramLong1, long paramLong2) {
/*  476 */     if (this.comparison != 0) {
/*  477 */       return this;
/*      */     }
/*  479 */     this.comparison = Long.compare(paramLong1, paramLong2);
/*  480 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int paramInt1, int paramInt2) {
/*  492 */     if (this.comparison != 0) {
/*  493 */       return this;
/*      */     }
/*  495 */     this.comparison = Integer.compare(paramInt1, paramInt2);
/*  496 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short paramShort1, short paramShort2) {
/*  508 */     if (this.comparison != 0) {
/*  509 */       return this;
/*      */     }
/*  511 */     this.comparison = Short.compare(paramShort1, paramShort2);
/*  512 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char paramChar1, char paramChar2) {
/*  524 */     if (this.comparison != 0) {
/*  525 */       return this;
/*      */     }
/*  527 */     this.comparison = Character.compare(paramChar1, paramChar2);
/*  528 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte paramByte1, byte paramByte2) {
/*  540 */     if (this.comparison != 0) {
/*  541 */       return this;
/*      */     }
/*  543 */     this.comparison = Byte.compare(paramByte1, paramByte2);
/*  544 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double paramDouble1, double paramDouble2) {
/*  561 */     if (this.comparison != 0) {
/*  562 */       return this;
/*      */     }
/*  564 */     this.comparison = Double.compare(paramDouble1, paramDouble2);
/*  565 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float paramFloat1, float paramFloat2) {
/*  582 */     if (this.comparison != 0) {
/*  583 */       return this;
/*      */     }
/*  585 */     this.comparison = Float.compare(paramFloat1, paramFloat2);
/*  586 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean paramBoolean1, boolean paramBoolean2) {
/*  598 */     if (this.comparison != 0) {
/*  599 */       return this;
/*      */     }
/*  601 */     if (paramBoolean1 == paramBoolean2) {
/*  602 */       return this;
/*      */     }
/*  604 */     if (paramBoolean1) {
/*  605 */       this.comparison = 1;
/*      */     } else {
/*  607 */       this.comparison = -1;
/*      */     } 
/*  609 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  634 */     return append(paramArrayOfObject1, paramArrayOfObject2, (Comparator<?>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Comparator<?> paramComparator) {
/*  661 */     if (this.comparison != 0) {
/*  662 */       return this;
/*      */     }
/*  664 */     if (paramArrayOfObject1 == paramArrayOfObject2) {
/*  665 */       return this;
/*      */     }
/*  667 */     if (paramArrayOfObject1 == null) {
/*  668 */       this.comparison = -1;
/*  669 */       return this;
/*      */     } 
/*  671 */     if (paramArrayOfObject2 == null) {
/*  672 */       this.comparison = 1;
/*  673 */       return this;
/*      */     } 
/*  675 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
/*  676 */       this.comparison = (paramArrayOfObject1.length < paramArrayOfObject2.length) ? -1 : 1;
/*  677 */       return this;
/*      */     } 
/*  679 */     for (byte b = 0; b < paramArrayOfObject1.length && this.comparison == 0; b++) {
/*  680 */       append(paramArrayOfObject1[b], paramArrayOfObject2[b], paramComparator);
/*      */     }
/*  682 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/*  701 */     if (this.comparison != 0) {
/*  702 */       return this;
/*      */     }
/*  704 */     if (paramArrayOflong1 == paramArrayOflong2) {
/*  705 */       return this;
/*      */     }
/*  707 */     if (paramArrayOflong1 == null) {
/*  708 */       this.comparison = -1;
/*  709 */       return this;
/*      */     } 
/*  711 */     if (paramArrayOflong2 == null) {
/*  712 */       this.comparison = 1;
/*  713 */       return this;
/*      */     } 
/*  715 */     if (paramArrayOflong1.length != paramArrayOflong2.length) {
/*  716 */       this.comparison = (paramArrayOflong1.length < paramArrayOflong2.length) ? -1 : 1;
/*  717 */       return this;
/*      */     } 
/*  719 */     for (byte b = 0; b < paramArrayOflong1.length && this.comparison == 0; b++) {
/*  720 */       append(paramArrayOflong1[b], paramArrayOflong2[b]);
/*      */     }
/*  722 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  741 */     if (this.comparison != 0) {
/*  742 */       return this;
/*      */     }
/*  744 */     if (paramArrayOfint1 == paramArrayOfint2) {
/*  745 */       return this;
/*      */     }
/*  747 */     if (paramArrayOfint1 == null) {
/*  748 */       this.comparison = -1;
/*  749 */       return this;
/*      */     } 
/*  751 */     if (paramArrayOfint2 == null) {
/*  752 */       this.comparison = 1;
/*  753 */       return this;
/*      */     } 
/*  755 */     if (paramArrayOfint1.length != paramArrayOfint2.length) {
/*  756 */       this.comparison = (paramArrayOfint1.length < paramArrayOfint2.length) ? -1 : 1;
/*  757 */       return this;
/*      */     } 
/*  759 */     for (byte b = 0; b < paramArrayOfint1.length && this.comparison == 0; b++) {
/*  760 */       append(paramArrayOfint1[b], paramArrayOfint2[b]);
/*      */     }
/*  762 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/*  781 */     if (this.comparison != 0) {
/*  782 */       return this;
/*      */     }
/*  784 */     if (paramArrayOfshort1 == paramArrayOfshort2) {
/*  785 */       return this;
/*      */     }
/*  787 */     if (paramArrayOfshort1 == null) {
/*  788 */       this.comparison = -1;
/*  789 */       return this;
/*      */     } 
/*  791 */     if (paramArrayOfshort2 == null) {
/*  792 */       this.comparison = 1;
/*  793 */       return this;
/*      */     } 
/*  795 */     if (paramArrayOfshort1.length != paramArrayOfshort2.length) {
/*  796 */       this.comparison = (paramArrayOfshort1.length < paramArrayOfshort2.length) ? -1 : 1;
/*  797 */       return this;
/*      */     } 
/*  799 */     for (byte b = 0; b < paramArrayOfshort1.length && this.comparison == 0; b++) {
/*  800 */       append(paramArrayOfshort1[b], paramArrayOfshort2[b]);
/*      */     }
/*  802 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/*  821 */     if (this.comparison != 0) {
/*  822 */       return this;
/*      */     }
/*  824 */     if (paramArrayOfchar1 == paramArrayOfchar2) {
/*  825 */       return this;
/*      */     }
/*  827 */     if (paramArrayOfchar1 == null) {
/*  828 */       this.comparison = -1;
/*  829 */       return this;
/*      */     } 
/*  831 */     if (paramArrayOfchar2 == null) {
/*  832 */       this.comparison = 1;
/*  833 */       return this;
/*      */     } 
/*  835 */     if (paramArrayOfchar1.length != paramArrayOfchar2.length) {
/*  836 */       this.comparison = (paramArrayOfchar1.length < paramArrayOfchar2.length) ? -1 : 1;
/*  837 */       return this;
/*      */     } 
/*  839 */     for (byte b = 0; b < paramArrayOfchar1.length && this.comparison == 0; b++) {
/*  840 */       append(paramArrayOfchar1[b], paramArrayOfchar2[b]);
/*      */     }
/*  842 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  861 */     if (this.comparison != 0) {
/*  862 */       return this;
/*      */     }
/*  864 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/*  865 */       return this;
/*      */     }
/*  867 */     if (paramArrayOfbyte1 == null) {
/*  868 */       this.comparison = -1;
/*  869 */       return this;
/*      */     } 
/*  871 */     if (paramArrayOfbyte2 == null) {
/*  872 */       this.comparison = 1;
/*  873 */       return this;
/*      */     } 
/*  875 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length) {
/*  876 */       this.comparison = (paramArrayOfbyte1.length < paramArrayOfbyte2.length) ? -1 : 1;
/*  877 */       return this;
/*      */     } 
/*  879 */     for (byte b = 0; b < paramArrayOfbyte1.length && this.comparison == 0; b++) {
/*  880 */       append(paramArrayOfbyte1[b], paramArrayOfbyte2[b]);
/*      */     }
/*  882 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/*  901 */     if (this.comparison != 0) {
/*  902 */       return this;
/*      */     }
/*  904 */     if (paramArrayOfdouble1 == paramArrayOfdouble2) {
/*  905 */       return this;
/*      */     }
/*  907 */     if (paramArrayOfdouble1 == null) {
/*  908 */       this.comparison = -1;
/*  909 */       return this;
/*      */     } 
/*  911 */     if (paramArrayOfdouble2 == null) {
/*  912 */       this.comparison = 1;
/*  913 */       return this;
/*      */     } 
/*  915 */     if (paramArrayOfdouble1.length != paramArrayOfdouble2.length) {
/*  916 */       this.comparison = (paramArrayOfdouble1.length < paramArrayOfdouble2.length) ? -1 : 1;
/*  917 */       return this;
/*      */     } 
/*  919 */     for (byte b = 0; b < paramArrayOfdouble1.length && this.comparison == 0; b++) {
/*  920 */       append(paramArrayOfdouble1[b], paramArrayOfdouble2[b]);
/*      */     }
/*  922 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/*  941 */     if (this.comparison != 0) {
/*  942 */       return this;
/*      */     }
/*  944 */     if (paramArrayOffloat1 == paramArrayOffloat2) {
/*  945 */       return this;
/*      */     }
/*  947 */     if (paramArrayOffloat1 == null) {
/*  948 */       this.comparison = -1;
/*  949 */       return this;
/*      */     } 
/*  951 */     if (paramArrayOffloat2 == null) {
/*  952 */       this.comparison = 1;
/*  953 */       return this;
/*      */     } 
/*  955 */     if (paramArrayOffloat1.length != paramArrayOffloat2.length) {
/*  956 */       this.comparison = (paramArrayOffloat1.length < paramArrayOffloat2.length) ? -1 : 1;
/*  957 */       return this;
/*      */     } 
/*  959 */     for (byte b = 0; b < paramArrayOffloat1.length && this.comparison == 0; b++) {
/*  960 */       append(paramArrayOffloat1[b], paramArrayOffloat2[b]);
/*      */     }
/*  962 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/*  981 */     if (this.comparison != 0) {
/*  982 */       return this;
/*      */     }
/*  984 */     if (paramArrayOfboolean1 == paramArrayOfboolean2) {
/*  985 */       return this;
/*      */     }
/*  987 */     if (paramArrayOfboolean1 == null) {
/*  988 */       this.comparison = -1;
/*  989 */       return this;
/*      */     } 
/*  991 */     if (paramArrayOfboolean2 == null) {
/*  992 */       this.comparison = 1;
/*  993 */       return this;
/*      */     } 
/*  995 */     if (paramArrayOfboolean1.length != paramArrayOfboolean2.length) {
/*  996 */       this.comparison = (paramArrayOfboolean1.length < paramArrayOfboolean2.length) ? -1 : 1;
/*  997 */       return this;
/*      */     } 
/*  999 */     for (byte b = 0; b < paramArrayOfboolean1.length && this.comparison == 0; b++) {
/* 1000 */       append(paramArrayOfboolean1[b], paramArrayOfboolean2[b]);
/*      */     }
/* 1002 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int toComparison() {
/* 1016 */     return this.comparison;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Integer build() {
/* 1031 */     return Integer.valueOf(toComparison());
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\CompareToBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */