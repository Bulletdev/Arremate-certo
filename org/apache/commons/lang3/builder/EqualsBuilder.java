/*      */ package org.apache.commons.lang3.builder;
/*      */ 
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.tuple.Pair;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EqualsBuilder
/*      */   implements Builder<Boolean>
/*      */ {
/*   98 */   private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Set<Pair<IDKey, IDKey>> getRegistry() {
/*  127 */     return REGISTRY.get();
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
/*      */   static Pair<IDKey, IDKey> getRegisterPair(Object paramObject1, Object paramObject2) {
/*  141 */     IDKey iDKey1 = new IDKey(paramObject1);
/*  142 */     IDKey iDKey2 = new IDKey(paramObject2);
/*  143 */     return Pair.of(iDKey1, iDKey2);
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
/*      */   static boolean isRegistered(Object paramObject1, Object paramObject2) {
/*  160 */     Set<Pair<IDKey, IDKey>> set = getRegistry();
/*  161 */     Pair<IDKey, IDKey> pair = getRegisterPair(paramObject1, paramObject2);
/*  162 */     Pair pair1 = Pair.of(pair.getRight(), pair.getLeft());
/*      */     
/*  164 */     return (set != null && (set
/*  165 */       .contains(pair) || set.contains(pair1)));
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
/*      */   private static void register(Object paramObject1, Object paramObject2) {
/*  178 */     Set<Pair<IDKey, IDKey>> set = getRegistry();
/*  179 */     if (set == null) {
/*  180 */       set = new HashSet<>();
/*  181 */       REGISTRY.set(set);
/*      */     } 
/*  183 */     Pair<IDKey, IDKey> pair = getRegisterPair(paramObject1, paramObject2);
/*  184 */     set.add(pair);
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
/*      */   private static void unregister(Object paramObject1, Object paramObject2) {
/*  200 */     Set<Pair<IDKey, IDKey>> set = getRegistry();
/*  201 */     if (set != null) {
/*  202 */       Pair<IDKey, IDKey> pair = getRegisterPair(paramObject1, paramObject2);
/*  203 */       set.remove(pair);
/*  204 */       if (set.isEmpty()) {
/*  205 */         REGISTRY.remove();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isEquals = true;
/*      */   
/*      */   private boolean testTransients = false;
/*      */   
/*      */   private boolean testRecursive = false;
/*      */   
/*      */   private List<Class<?>> bypassReflectionClasses;
/*      */   
/*  219 */   private Class<?> reflectUpToClass = null;
/*  220 */   private String[] excludeFields = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder() {
/*  230 */     this.bypassReflectionClasses = new ArrayList<>();
/*  231 */     this.bypassReflectionClasses.add(String.class);
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
/*      */   public EqualsBuilder setTestTransients(boolean paramBoolean) {
/*  243 */     this.testTransients = paramBoolean;
/*  244 */     return this;
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
/*      */   public EqualsBuilder setTestRecursive(boolean paramBoolean) {
/*  257 */     this.testRecursive = paramBoolean;
/*  258 */     return this;
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
/*      */   public EqualsBuilder setBypassReflectionClasses(List<Class<?>> paramList) {
/*  275 */     this.bypassReflectionClasses = paramList;
/*  276 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder setReflectUpToClass(Class<?> paramClass) {
/*  286 */     this.reflectUpToClass = paramClass;
/*  287 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder setExcludeFields(String... paramVarArgs) {
/*  297 */     this.excludeFields = paramVarArgs;
/*  298 */     return this;
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
/*      */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, Collection<String> paramCollection) {
/*  325 */     return reflectionEquals(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
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
/*      */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, String... paramVarArgs) {
/*  351 */     return reflectionEquals(paramObject1, paramObject2, false, null, paramVarArgs);
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
/*      */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  378 */     return reflectionEquals(paramObject1, paramObject2, paramBoolean, null, new String[0]);
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
/*      */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass, String... paramVarArgs) {
/*  412 */     return reflectionEquals(paramObject1, paramObject2, paramBoolean, paramClass, false, paramVarArgs);
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
/*      */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean1, Class<?> paramClass, boolean paramBoolean2, String... paramVarArgs) {
/*  453 */     if (paramObject1 == paramObject2) {
/*  454 */       return true;
/*      */     }
/*  456 */     if (paramObject1 == null || paramObject2 == null) {
/*  457 */       return false;
/*      */     }
/*  459 */     return (new EqualsBuilder())
/*  460 */       .setExcludeFields(paramVarArgs)
/*  461 */       .setReflectUpToClass(paramClass)
/*  462 */       .setTestTransients(paramBoolean1)
/*  463 */       .setTestRecursive(paramBoolean2)
/*  464 */       .reflectionAppend(paramObject1, paramObject2)
/*  465 */       .isEquals();
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
/*      */   public EqualsBuilder reflectionAppend(Object paramObject1, Object paramObject2) {
/*      */     Class<?> clazz3;
/*  496 */     if (!this.isEquals) {
/*  497 */       return this;
/*      */     }
/*  499 */     if (paramObject1 == paramObject2) {
/*  500 */       return this;
/*      */     }
/*  502 */     if (paramObject1 == null || paramObject2 == null) {
/*  503 */       this.isEquals = false;
/*  504 */       return this;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  511 */     Class<?> clazz1 = paramObject1.getClass();
/*  512 */     Class<?> clazz2 = paramObject2.getClass();
/*      */     
/*  514 */     if (clazz1.isInstance(paramObject2)) {
/*  515 */       clazz3 = clazz1;
/*  516 */       if (!clazz2.isInstance(paramObject1))
/*      */       {
/*  518 */         clazz3 = clazz2;
/*      */       }
/*  520 */     } else if (clazz2.isInstance(paramObject1)) {
/*  521 */       clazz3 = clazz2;
/*  522 */       if (!clazz1.isInstance(paramObject2))
/*      */       {
/*  524 */         clazz3 = clazz1;
/*      */       }
/*      */     } else {
/*      */       
/*  528 */       this.isEquals = false;
/*  529 */       return this;
/*      */     } 
/*      */     
/*      */     try {
/*  533 */       if (clazz3.isArray()) {
/*  534 */         append(paramObject1, paramObject2);
/*      */       
/*      */       }
/*  537 */       else if (this.bypassReflectionClasses != null && (this.bypassReflectionClasses
/*  538 */         .contains(clazz1) || this.bypassReflectionClasses.contains(clazz2))) {
/*  539 */         this.isEquals = paramObject1.equals(paramObject2);
/*      */       } else {
/*  541 */         reflectionAppend(paramObject1, paramObject2, clazz3);
/*  542 */         while (clazz3.getSuperclass() != null && clazz3 != this.reflectUpToClass) {
/*  543 */           clazz3 = clazz3.getSuperclass();
/*  544 */           reflectionAppend(paramObject1, paramObject2, clazz3);
/*      */         }
/*      */       
/*      */       } 
/*  548 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  554 */       this.isEquals = false;
/*  555 */       return this;
/*      */     } 
/*  557 */     return this;
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
/*      */   private void reflectionAppend(Object paramObject1, Object paramObject2, Class<?> paramClass) {
/*  573 */     if (isRegistered(paramObject1, paramObject2)) {
/*      */       return;
/*      */     }
/*      */     
/*      */     try {
/*  578 */       register(paramObject1, paramObject2);
/*  579 */       Field[] arrayOfField = paramClass.getDeclaredFields();
/*  580 */       AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/*  581 */       for (byte b = 0; b < arrayOfField.length && this.isEquals; b++) {
/*  582 */         Field field = arrayOfField[b];
/*  583 */         if (!ArrayUtils.contains((Object[])this.excludeFields, field.getName()) && 
/*  584 */           !field.getName().contains("$") && (this.testTransients || 
/*  585 */           !Modifier.isTransient(field.getModifiers())) && 
/*  586 */           !Modifier.isStatic(field.getModifiers()) && 
/*  587 */           !field.isAnnotationPresent((Class)EqualsExclude.class)) {
/*      */           try {
/*  589 */             append(field.get(paramObject1), field.get(paramObject2));
/*  590 */           } catch (IllegalAccessException illegalAccessException) {
/*      */ 
/*      */             
/*  593 */             throw new InternalError("Unexpected IllegalAccessException");
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } finally {
/*  598 */       unregister(paramObject1, paramObject2);
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
/*      */   public EqualsBuilder appendSuper(boolean paramBoolean) {
/*  612 */     if (!this.isEquals) {
/*  613 */       return this;
/*      */     }
/*  615 */     this.isEquals = paramBoolean;
/*  616 */     return this;
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
/*      */   public EqualsBuilder append(Object paramObject1, Object paramObject2) {
/*  633 */     if (!this.isEquals) {
/*  634 */       return this;
/*      */     }
/*  636 */     if (paramObject1 == paramObject2) {
/*  637 */       return this;
/*      */     }
/*  639 */     if (paramObject1 == null || paramObject2 == null) {
/*  640 */       setEquals(false);
/*  641 */       return this;
/*      */     } 
/*  643 */     Class<?> clazz = paramObject1.getClass();
/*  644 */     if (clazz.isArray()) {
/*      */ 
/*      */       
/*  647 */       appendArray(paramObject1, paramObject2);
/*      */     
/*      */     }
/*  650 */     else if (this.testRecursive && !ClassUtils.isPrimitiveOrWrapper(clazz)) {
/*  651 */       reflectionAppend(paramObject1, paramObject2);
/*      */     } else {
/*  653 */       this.isEquals = paramObject1.equals(paramObject2);
/*      */     } 
/*      */     
/*  656 */     return this;
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
/*      */   private void appendArray(Object paramObject1, Object paramObject2) {
/*  669 */     if (paramObject1.getClass() != paramObject2.getClass()) {
/*  670 */       setEquals(false);
/*  671 */     } else if (paramObject1 instanceof long[]) {
/*  672 */       append((long[])paramObject1, (long[])paramObject2);
/*  673 */     } else if (paramObject1 instanceof int[]) {
/*  674 */       append((int[])paramObject1, (int[])paramObject2);
/*  675 */     } else if (paramObject1 instanceof short[]) {
/*  676 */       append((short[])paramObject1, (short[])paramObject2);
/*  677 */     } else if (paramObject1 instanceof char[]) {
/*  678 */       append((char[])paramObject1, (char[])paramObject2);
/*  679 */     } else if (paramObject1 instanceof byte[]) {
/*  680 */       append((byte[])paramObject1, (byte[])paramObject2);
/*  681 */     } else if (paramObject1 instanceof double[]) {
/*  682 */       append((double[])paramObject1, (double[])paramObject2);
/*  683 */     } else if (paramObject1 instanceof float[]) {
/*  684 */       append((float[])paramObject1, (float[])paramObject2);
/*  685 */     } else if (paramObject1 instanceof boolean[]) {
/*  686 */       append((boolean[])paramObject1, (boolean[])paramObject2);
/*      */     } else {
/*      */       
/*  689 */       append((Object[])paramObject1, (Object[])paramObject2);
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
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(long paramLong1, long paramLong2) {
/*  705 */     if (!this.isEquals) {
/*  706 */       return this;
/*      */     }
/*  708 */     this.isEquals = (paramLong1 == paramLong2);
/*  709 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(int paramInt1, int paramInt2) {
/*  720 */     if (!this.isEquals) {
/*  721 */       return this;
/*      */     }
/*  723 */     this.isEquals = (paramInt1 == paramInt2);
/*  724 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(short paramShort1, short paramShort2) {
/*  735 */     if (!this.isEquals) {
/*  736 */       return this;
/*      */     }
/*  738 */     this.isEquals = (paramShort1 == paramShort2);
/*  739 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(char paramChar1, char paramChar2) {
/*  750 */     if (!this.isEquals) {
/*  751 */       return this;
/*      */     }
/*  753 */     this.isEquals = (paramChar1 == paramChar2);
/*  754 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(byte paramByte1, byte paramByte2) {
/*  765 */     if (!this.isEquals) {
/*  766 */       return this;
/*      */     }
/*  768 */     this.isEquals = (paramByte1 == paramByte2);
/*  769 */     return this;
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
/*      */   public EqualsBuilder append(double paramDouble1, double paramDouble2) {
/*  786 */     if (!this.isEquals) {
/*  787 */       return this;
/*      */     }
/*  789 */     return append(Double.doubleToLongBits(paramDouble1), Double.doubleToLongBits(paramDouble2));
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
/*      */   public EqualsBuilder append(float paramFloat1, float paramFloat2) {
/*  806 */     if (!this.isEquals) {
/*  807 */       return this;
/*      */     }
/*  809 */     return append(Float.floatToIntBits(paramFloat1), Float.floatToIntBits(paramFloat2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EqualsBuilder append(boolean paramBoolean1, boolean paramBoolean2) {
/*  820 */     if (!this.isEquals) {
/*  821 */       return this;
/*      */     }
/*  823 */     this.isEquals = (paramBoolean1 == paramBoolean2);
/*  824 */     return this;
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
/*      */   public EqualsBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  841 */     if (!this.isEquals) {
/*  842 */       return this;
/*      */     }
/*  844 */     if (paramArrayOfObject1 == paramArrayOfObject2) {
/*  845 */       return this;
/*      */     }
/*  847 */     if (paramArrayOfObject1 == null || paramArrayOfObject2 == null) {
/*  848 */       setEquals(false);
/*  849 */       return this;
/*      */     } 
/*  851 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
/*  852 */       setEquals(false);
/*  853 */       return this;
/*      */     } 
/*  855 */     for (byte b = 0; b < paramArrayOfObject1.length && this.isEquals; b++) {
/*  856 */       append(paramArrayOfObject1[b], paramArrayOfObject2[b]);
/*      */     }
/*  858 */     return this;
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
/*      */   public EqualsBuilder append(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/*  872 */     if (!this.isEquals) {
/*  873 */       return this;
/*      */     }
/*  875 */     if (paramArrayOflong1 == paramArrayOflong2) {
/*  876 */       return this;
/*      */     }
/*  878 */     if (paramArrayOflong1 == null || paramArrayOflong2 == null) {
/*  879 */       setEquals(false);
/*  880 */       return this;
/*      */     } 
/*  882 */     if (paramArrayOflong1.length != paramArrayOflong2.length) {
/*  883 */       setEquals(false);
/*  884 */       return this;
/*      */     } 
/*  886 */     for (byte b = 0; b < paramArrayOflong1.length && this.isEquals; b++) {
/*  887 */       append(paramArrayOflong1[b], paramArrayOflong2[b]);
/*      */     }
/*  889 */     return this;
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
/*      */   public EqualsBuilder append(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  903 */     if (!this.isEquals) {
/*  904 */       return this;
/*      */     }
/*  906 */     if (paramArrayOfint1 == paramArrayOfint2) {
/*  907 */       return this;
/*      */     }
/*  909 */     if (paramArrayOfint1 == null || paramArrayOfint2 == null) {
/*  910 */       setEquals(false);
/*  911 */       return this;
/*      */     } 
/*  913 */     if (paramArrayOfint1.length != paramArrayOfint2.length) {
/*  914 */       setEquals(false);
/*  915 */       return this;
/*      */     } 
/*  917 */     for (byte b = 0; b < paramArrayOfint1.length && this.isEquals; b++) {
/*  918 */       append(paramArrayOfint1[b], paramArrayOfint2[b]);
/*      */     }
/*  920 */     return this;
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
/*      */   public EqualsBuilder append(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/*  934 */     if (!this.isEquals) {
/*  935 */       return this;
/*      */     }
/*  937 */     if (paramArrayOfshort1 == paramArrayOfshort2) {
/*  938 */       return this;
/*      */     }
/*  940 */     if (paramArrayOfshort1 == null || paramArrayOfshort2 == null) {
/*  941 */       setEquals(false);
/*  942 */       return this;
/*      */     } 
/*  944 */     if (paramArrayOfshort1.length != paramArrayOfshort2.length) {
/*  945 */       setEquals(false);
/*  946 */       return this;
/*      */     } 
/*  948 */     for (byte b = 0; b < paramArrayOfshort1.length && this.isEquals; b++) {
/*  949 */       append(paramArrayOfshort1[b], paramArrayOfshort2[b]);
/*      */     }
/*  951 */     return this;
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
/*      */   public EqualsBuilder append(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/*  965 */     if (!this.isEquals) {
/*  966 */       return this;
/*      */     }
/*  968 */     if (paramArrayOfchar1 == paramArrayOfchar2) {
/*  969 */       return this;
/*      */     }
/*  971 */     if (paramArrayOfchar1 == null || paramArrayOfchar2 == null) {
/*  972 */       setEquals(false);
/*  973 */       return this;
/*      */     } 
/*  975 */     if (paramArrayOfchar1.length != paramArrayOfchar2.length) {
/*  976 */       setEquals(false);
/*  977 */       return this;
/*      */     } 
/*  979 */     for (byte b = 0; b < paramArrayOfchar1.length && this.isEquals; b++) {
/*  980 */       append(paramArrayOfchar1[b], paramArrayOfchar2[b]);
/*      */     }
/*  982 */     return this;
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
/*      */   public EqualsBuilder append(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  996 */     if (!this.isEquals) {
/*  997 */       return this;
/*      */     }
/*  999 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/* 1000 */       return this;
/*      */     }
/* 1002 */     if (paramArrayOfbyte1 == null || paramArrayOfbyte2 == null) {
/* 1003 */       setEquals(false);
/* 1004 */       return this;
/*      */     } 
/* 1006 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length) {
/* 1007 */       setEquals(false);
/* 1008 */       return this;
/*      */     } 
/* 1010 */     for (byte b = 0; b < paramArrayOfbyte1.length && this.isEquals; b++) {
/* 1011 */       append(paramArrayOfbyte1[b], paramArrayOfbyte2[b]);
/*      */     }
/* 1013 */     return this;
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
/*      */   public EqualsBuilder append(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 1027 */     if (!this.isEquals) {
/* 1028 */       return this;
/*      */     }
/* 1030 */     if (paramArrayOfdouble1 == paramArrayOfdouble2) {
/* 1031 */       return this;
/*      */     }
/* 1033 */     if (paramArrayOfdouble1 == null || paramArrayOfdouble2 == null) {
/* 1034 */       setEquals(false);
/* 1035 */       return this;
/*      */     } 
/* 1037 */     if (paramArrayOfdouble1.length != paramArrayOfdouble2.length) {
/* 1038 */       setEquals(false);
/* 1039 */       return this;
/*      */     } 
/* 1041 */     for (byte b = 0; b < paramArrayOfdouble1.length && this.isEquals; b++) {
/* 1042 */       append(paramArrayOfdouble1[b], paramArrayOfdouble2[b]);
/*      */     }
/* 1044 */     return this;
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
/*      */   public EqualsBuilder append(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1058 */     if (!this.isEquals) {
/* 1059 */       return this;
/*      */     }
/* 1061 */     if (paramArrayOffloat1 == paramArrayOffloat2) {
/* 1062 */       return this;
/*      */     }
/* 1064 */     if (paramArrayOffloat1 == null || paramArrayOffloat2 == null) {
/* 1065 */       setEquals(false);
/* 1066 */       return this;
/*      */     } 
/* 1068 */     if (paramArrayOffloat1.length != paramArrayOffloat2.length) {
/* 1069 */       setEquals(false);
/* 1070 */       return this;
/*      */     } 
/* 1072 */     for (byte b = 0; b < paramArrayOffloat1.length && this.isEquals; b++) {
/* 1073 */       append(paramArrayOffloat1[b], paramArrayOffloat2[b]);
/*      */     }
/* 1075 */     return this;
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
/*      */   public EqualsBuilder append(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 1089 */     if (!this.isEquals) {
/* 1090 */       return this;
/*      */     }
/* 1092 */     if (paramArrayOfboolean1 == paramArrayOfboolean2) {
/* 1093 */       return this;
/*      */     }
/* 1095 */     if (paramArrayOfboolean1 == null || paramArrayOfboolean2 == null) {
/* 1096 */       setEquals(false);
/* 1097 */       return this;
/*      */     } 
/* 1099 */     if (paramArrayOfboolean1.length != paramArrayOfboolean2.length) {
/* 1100 */       setEquals(false);
/* 1101 */       return this;
/*      */     } 
/* 1103 */     for (byte b = 0; b < paramArrayOfboolean1.length && this.isEquals; b++) {
/* 1104 */       append(paramArrayOfboolean1[b], paramArrayOfboolean2[b]);
/*      */     }
/* 1106 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEquals() {
/* 1116 */     return this.isEquals;
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
/*      */   public Boolean build() {
/* 1130 */     return Boolean.valueOf(isEquals());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setEquals(boolean paramBoolean) {
/* 1140 */     this.isEquals = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/* 1148 */     this.isEquals = true;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\EqualsBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */