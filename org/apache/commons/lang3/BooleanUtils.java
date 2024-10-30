/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import org.apache.commons.lang3.math.NumberUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BooleanUtils
/*      */ {
/*      */   public static Boolean negate(Boolean paramBoolean) {
/*   64 */     if (paramBoolean == null) {
/*   65 */       return null;
/*      */     }
/*   67 */     return paramBoolean.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
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
/*      */   public static boolean isTrue(Boolean paramBoolean) {
/*   87 */     return Boolean.TRUE.equals(paramBoolean);
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
/*      */   public static boolean isNotTrue(Boolean paramBoolean) {
/*  105 */     return !isTrue(paramBoolean);
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
/*      */   public static boolean isFalse(Boolean paramBoolean) {
/*  123 */     return Boolean.FALSE.equals(paramBoolean);
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
/*      */   public static boolean isNotFalse(Boolean paramBoolean) {
/*  141 */     return !isFalse(paramBoolean);
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
/*      */   public static boolean toBoolean(Boolean paramBoolean) {
/*  159 */     return (paramBoolean != null && paramBoolean.booleanValue());
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
/*      */   public static boolean toBooleanDefaultIfNull(Boolean paramBoolean, boolean paramBoolean1) {
/*  179 */     if (paramBoolean == null) {
/*  180 */       return paramBoolean1;
/*      */     }
/*  182 */     return paramBoolean.booleanValue();
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
/*      */   public static boolean toBoolean(int paramInt) {
/*  202 */     return (paramInt != 0);
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
/*      */   public static Boolean toBooleanObject(int paramInt) {
/*  220 */     return (paramInt == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*      */   public static Boolean toBooleanObject(Integer paramInteger) {
/*  243 */     if (paramInteger == null) {
/*  244 */       return null;
/*      */     }
/*  246 */     return (paramInteger.intValue() == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*      */   public static boolean toBoolean(int paramInt1, int paramInt2, int paramInt3) {
/*  271 */     if (paramInt1 == paramInt2) {
/*  272 */       return true;
/*      */     }
/*  274 */     if (paramInt1 == paramInt3) {
/*  275 */       return false;
/*      */     }
/*  277 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*      */   public static boolean toBoolean(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3) {
/*  298 */     if (paramInteger1 == null) {
/*  299 */       if (paramInteger2 == null) {
/*  300 */         return true;
/*      */       }
/*  302 */       if (paramInteger3 == null)
/*  303 */         return false; 
/*      */     } else {
/*  305 */       if (paramInteger1.equals(paramInteger2))
/*  306 */         return true; 
/*  307 */       if (paramInteger1.equals(paramInteger3))
/*  308 */         return false; 
/*      */     } 
/*  310 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*      */   public static Boolean toBooleanObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  339 */     if (paramInt1 == paramInt2) {
/*  340 */       return Boolean.TRUE;
/*      */     }
/*  342 */     if (paramInt1 == paramInt3) {
/*  343 */       return Boolean.FALSE;
/*      */     }
/*  345 */     if (paramInt1 == paramInt4) {
/*  346 */       return null;
/*      */     }
/*  348 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*      */   public static Boolean toBooleanObject(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4) {
/*  377 */     if (paramInteger1 == null) {
/*  378 */       if (paramInteger2 == null) {
/*  379 */         return Boolean.TRUE;
/*      */       }
/*  381 */       if (paramInteger3 == null) {
/*  382 */         return Boolean.FALSE;
/*      */       }
/*  384 */       if (paramInteger4 == null)
/*  385 */         return null; 
/*      */     } else {
/*  387 */       if (paramInteger1.equals(paramInteger2))
/*  388 */         return Boolean.TRUE; 
/*  389 */       if (paramInteger1.equals(paramInteger3))
/*  390 */         return Boolean.FALSE; 
/*  391 */       if (paramInteger1.equals(paramInteger4))
/*  392 */         return null; 
/*      */     } 
/*  394 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*      */   public static int toInteger(boolean paramBoolean) {
/*  412 */     return paramBoolean ? 1 : 0;
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
/*      */   public static Integer toIntegerObject(boolean paramBoolean) {
/*  428 */     return paramBoolean ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*      */   public static Integer toIntegerObject(Boolean paramBoolean) {
/*  446 */     if (paramBoolean == null) {
/*  447 */       return null;
/*      */     }
/*  449 */     return paramBoolean.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*      */   public static int toInteger(boolean paramBoolean, int paramInt1, int paramInt2) {
/*  466 */     return paramBoolean ? paramInt1 : paramInt2;
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
/*      */   public static int toInteger(Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
/*  485 */     if (paramBoolean == null) {
/*  486 */       return paramInt3;
/*      */     }
/*  488 */     return paramBoolean.booleanValue() ? paramInt1 : paramInt2;
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
/*      */   public static Integer toIntegerObject(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2) {
/*  505 */     return paramBoolean ? paramInteger1 : paramInteger2;
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
/*      */   public static Integer toIntegerObject(Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3) {
/*  524 */     if (paramBoolean == null) {
/*  525 */       return paramInteger3;
/*      */     }
/*  527 */     return paramBoolean.booleanValue() ? paramInteger1 : paramInteger2;
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
/*      */ 
/*      */   
/*      */   public static Boolean toBooleanObject(String paramString) {
/*      */     char c1;
/*      */     char c2;
/*      */     char c3;
/*      */     char c4;
/*      */     char c5;
/*  576 */     if (paramString == "true") {
/*  577 */       return Boolean.TRUE;
/*      */     }
/*  579 */     if (paramString == null) {
/*  580 */       return null;
/*      */     }
/*  582 */     switch (paramString.length()) {
/*      */       case 1:
/*  584 */         c1 = paramString.charAt(0);
/*  585 */         if (c1 == 'y' || c1 == 'Y' || c1 == 't' || c1 == 'T' || c1 == '1')
/*      */         {
/*      */           
/*  588 */           return Boolean.TRUE;
/*      */         }
/*  590 */         if (c1 == 'n' || c1 == 'N' || c1 == 'f' || c1 == 'F' || c1 == '0')
/*      */         {
/*      */           
/*  593 */           return Boolean.FALSE;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 2:
/*  598 */         c1 = paramString.charAt(0);
/*  599 */         c2 = paramString.charAt(1);
/*  600 */         if ((c1 == 'o' || c1 == 'O') && (c2 == 'n' || c2 == 'N'))
/*      */         {
/*  602 */           return Boolean.TRUE;
/*      */         }
/*  604 */         if ((c1 == 'n' || c1 == 'N') && (c2 == 'o' || c2 == 'O'))
/*      */         {
/*  606 */           return Boolean.FALSE;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 3:
/*  611 */         c1 = paramString.charAt(0);
/*  612 */         c2 = paramString.charAt(1);
/*  613 */         c3 = paramString.charAt(2);
/*  614 */         if ((c1 == 'y' || c1 == 'Y') && (c2 == 'e' || c2 == 'E') && (c3 == 's' || c3 == 'S'))
/*      */         {
/*      */           
/*  617 */           return Boolean.TRUE;
/*      */         }
/*  619 */         if ((c1 == 'o' || c1 == 'O') && (c2 == 'f' || c2 == 'F') && (c3 == 'f' || c3 == 'F'))
/*      */         {
/*      */           
/*  622 */           return Boolean.FALSE;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 4:
/*  627 */         c1 = paramString.charAt(0);
/*  628 */         c2 = paramString.charAt(1);
/*  629 */         c3 = paramString.charAt(2);
/*  630 */         c4 = paramString.charAt(3);
/*  631 */         if ((c1 == 't' || c1 == 'T') && (c2 == 'r' || c2 == 'R') && (c3 == 'u' || c3 == 'U') && (c4 == 'e' || c4 == 'E'))
/*      */         {
/*      */ 
/*      */           
/*  635 */           return Boolean.TRUE;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 5:
/*  640 */         c1 = paramString.charAt(0);
/*  641 */         c2 = paramString.charAt(1);
/*  642 */         c3 = paramString.charAt(2);
/*  643 */         c4 = paramString.charAt(3);
/*  644 */         c5 = paramString.charAt(4);
/*  645 */         if ((c1 == 'f' || c1 == 'F') && (c2 == 'a' || c2 == 'A') && (c3 == 'l' || c3 == 'L') && (c4 == 's' || c4 == 'S') && (c5 == 'e' || c5 == 'E'))
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*  650 */           return Boolean.FALSE;
/*      */         }
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  658 */     return null;
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
/*      */   public static Boolean toBooleanObject(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  688 */     if (paramString1 == null) {
/*  689 */       if (paramString2 == null) {
/*  690 */         return Boolean.TRUE;
/*      */       }
/*  692 */       if (paramString3 == null) {
/*  693 */         return Boolean.FALSE;
/*      */       }
/*  695 */       if (paramString4 == null)
/*  696 */         return null; 
/*      */     } else {
/*  698 */       if (paramString1.equals(paramString2))
/*  699 */         return Boolean.TRUE; 
/*  700 */       if (paramString1.equals(paramString3))
/*  701 */         return Boolean.FALSE; 
/*  702 */       if (paramString1.equals(paramString4)) {
/*  703 */         return null;
/*      */       }
/*      */     } 
/*  706 */     throw new IllegalArgumentException("The String did not match any specified value");
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
/*      */   public static boolean toBoolean(String paramString) {
/*  741 */     return (toBooleanObject(paramString) == Boolean.TRUE);
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
/*      */   public static boolean toBoolean(String paramString1, String paramString2, String paramString3) {
/*  759 */     if (paramString1 == paramString2)
/*  760 */       return true; 
/*  761 */     if (paramString1 == paramString3)
/*  762 */       return false; 
/*  763 */     if (paramString1 != null) {
/*  764 */       if (paramString1.equals(paramString2))
/*  765 */         return true; 
/*  766 */       if (paramString1.equals(paramString3)) {
/*  767 */         return false;
/*      */       }
/*      */     } 
/*  770 */     throw new IllegalArgumentException("The String did not match either specified value");
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
/*      */   public static String toStringTrueFalse(Boolean paramBoolean) {
/*  789 */     return toString(paramBoolean, "true", "false", null);
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
/*      */   public static String toStringOnOff(Boolean paramBoolean) {
/*  806 */     return toString(paramBoolean, "on", "off", null);
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
/*      */   public static String toStringYesNo(Boolean paramBoolean) {
/*  823 */     return toString(paramBoolean, "yes", "no", null);
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
/*      */   public static String toString(Boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
/*  842 */     if (paramBoolean == null) {
/*  843 */       return paramString3;
/*      */     }
/*  845 */     return paramBoolean.booleanValue() ? paramString1 : paramString2;
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
/*      */   public static String toStringTrueFalse(boolean paramBoolean) {
/*  863 */     return toString(paramBoolean, "true", "false");
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
/*      */   public static String toStringOnOff(boolean paramBoolean) {
/*  879 */     return toString(paramBoolean, "on", "off");
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
/*      */   public static String toStringYesNo(boolean paramBoolean) {
/*  895 */     return toString(paramBoolean, "yes", "no");
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
/*      */   public static String toString(boolean paramBoolean, String paramString1, String paramString2) {
/*  912 */     return paramBoolean ? paramString1 : paramString2;
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
/*      */   public static boolean and(boolean... paramVarArgs) {
/*  937 */     if (paramVarArgs == null) {
/*  938 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/*  940 */     if (paramVarArgs.length == 0) {
/*  941 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/*  943 */     for (boolean bool : paramVarArgs) {
/*  944 */       if (!bool) {
/*  945 */         return false;
/*      */       }
/*      */     } 
/*  948 */     return true;
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
/*      */   public static Boolean and(Boolean... paramVarArgs) {
/*  972 */     if (paramVarArgs == null) {
/*  973 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/*  975 */     if (paramVarArgs.length == 0) {
/*  976 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/*      */     try {
/*  979 */       boolean[] arrayOfBoolean = ArrayUtils.toPrimitive(paramVarArgs);
/*  980 */       return and(arrayOfBoolean) ? Boolean.TRUE : Boolean.FALSE;
/*  981 */     } catch (NullPointerException nullPointerException) {
/*  982 */       throw new IllegalArgumentException("The array must not contain any null elements");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean or(boolean... paramVarArgs) {
/* 1005 */     if (paramVarArgs == null) {
/* 1006 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 1008 */     if (paramVarArgs.length == 0) {
/* 1009 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/* 1011 */     for (boolean bool : paramVarArgs) {
/* 1012 */       if (bool) {
/* 1013 */         return true;
/*      */       }
/*      */     } 
/* 1016 */     return false;
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
/*      */   public static Boolean or(Boolean... paramVarArgs) {
/* 1040 */     if (paramVarArgs == null) {
/* 1041 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 1043 */     if (paramVarArgs.length == 0) {
/* 1044 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/*      */     try {
/* 1047 */       boolean[] arrayOfBoolean = ArrayUtils.toPrimitive(paramVarArgs);
/* 1048 */       return or(arrayOfBoolean) ? Boolean.TRUE : Boolean.FALSE;
/* 1049 */     } catch (NullPointerException nullPointerException) {
/* 1050 */       throw new IllegalArgumentException("The array must not contain any null elements");
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean xor(boolean... paramVarArgs) {
/* 1069 */     if (paramVarArgs == null) {
/* 1070 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 1072 */     if (paramVarArgs.length == 0) {
/* 1073 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/*      */ 
/*      */     
/* 1077 */     boolean bool = false;
/* 1078 */     for (boolean bool1 : paramVarArgs) {
/* 1079 */       bool ^= bool1;
/*      */     }
/*      */     
/* 1082 */     return bool;
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
/*      */   public static Boolean xor(Boolean... paramVarArgs) {
/* 1102 */     if (paramVarArgs == null) {
/* 1103 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 1105 */     if (paramVarArgs.length == 0) {
/* 1106 */       throw new IllegalArgumentException("Array is empty");
/*      */     }
/*      */     try {
/* 1109 */       boolean[] arrayOfBoolean = ArrayUtils.toPrimitive(paramVarArgs);
/* 1110 */       return xor(arrayOfBoolean) ? Boolean.TRUE : Boolean.FALSE;
/* 1111 */     } catch (NullPointerException nullPointerException) {
/* 1112 */       throw new IllegalArgumentException("The array must not contain any null elements");
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
/*      */   public static int compare(boolean paramBoolean1, boolean paramBoolean2) {
/* 1127 */     if (paramBoolean1 == paramBoolean2) {
/* 1128 */       return 0;
/*      */     }
/* 1130 */     return paramBoolean1 ? 1 : -1;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\BooleanUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */