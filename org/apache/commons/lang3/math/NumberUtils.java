/*      */ package org.apache.commons.lang3.math;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.math.RoundingMode;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NumberUtils
/*      */ {
/*   35 */   public static final Long LONG_ZERO = Long.valueOf(0L);
/*      */   
/*   37 */   public static final Long LONG_ONE = Long.valueOf(1L);
/*      */   
/*   39 */   public static final Long LONG_MINUS_ONE = Long.valueOf(-1L);
/*      */   
/*   41 */   public static final Integer INTEGER_ZERO = Integer.valueOf(0);
/*      */   
/*   43 */   public static final Integer INTEGER_ONE = Integer.valueOf(1);
/*      */   
/*   45 */   public static final Integer INTEGER_TWO = Integer.valueOf(2);
/*      */   
/*   47 */   public static final Integer INTEGER_MINUS_ONE = Integer.valueOf(-1);
/*      */   
/*   49 */   public static final Short SHORT_ZERO = Short.valueOf((short)0);
/*      */   
/*   51 */   public static final Short SHORT_ONE = Short.valueOf((short)1);
/*      */   
/*   53 */   public static final Short SHORT_MINUS_ONE = Short.valueOf((short)-1);
/*      */   
/*   55 */   public static final Byte BYTE_ZERO = Byte.valueOf((byte)0);
/*      */   
/*   57 */   public static final Byte BYTE_ONE = Byte.valueOf((byte)1);
/*      */   
/*   59 */   public static final Byte BYTE_MINUS_ONE = Byte.valueOf((byte)-1);
/*      */   
/*   61 */   public static final Double DOUBLE_ZERO = Double.valueOf(0.0D);
/*      */   
/*   63 */   public static final Double DOUBLE_ONE = Double.valueOf(1.0D);
/*      */   
/*   65 */   public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0D);
/*      */   
/*   67 */   public static final Float FLOAT_ZERO = Float.valueOf(0.0F);
/*      */   
/*   69 */   public static final Float FLOAT_ONE = Float.valueOf(1.0F);
/*      */   
/*   71 */   public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int toInt(String paramString) {
/*  104 */     return toInt(paramString, 0);
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
/*      */   public static int toInt(String paramString, int paramInt) {
/*  125 */     if (paramString == null) {
/*  126 */       return paramInt;
/*      */     }
/*      */     try {
/*  129 */       return Integer.parseInt(paramString);
/*  130 */     } catch (NumberFormatException numberFormatException) {
/*  131 */       return paramInt;
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
/*      */   public static long toLong(String paramString) {
/*  153 */     return toLong(paramString, 0L);
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
/*      */   public static long toLong(String paramString, long paramLong) {
/*  174 */     if (paramString == null) {
/*  175 */       return paramLong;
/*      */     }
/*      */     try {
/*  178 */       return Long.parseLong(paramString);
/*  179 */     } catch (NumberFormatException numberFormatException) {
/*  180 */       return paramLong;
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
/*      */   public static float toFloat(String paramString) {
/*  203 */     return toFloat(paramString, 0.0F);
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
/*      */   public static float toFloat(String paramString, float paramFloat) {
/*  226 */     if (paramString == null) {
/*  227 */       return paramFloat;
/*      */     }
/*      */     try {
/*  230 */       return Float.parseFloat(paramString);
/*  231 */     } catch (NumberFormatException numberFormatException) {
/*  232 */       return paramFloat;
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
/*      */   public static double toDouble(String paramString) {
/*  255 */     return toDouble(paramString, 0.0D);
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
/*      */   public static double toDouble(String paramString, double paramDouble) {
/*  278 */     if (paramString == null) {
/*  279 */       return paramDouble;
/*      */     }
/*      */     try {
/*  282 */       return Double.parseDouble(paramString);
/*  283 */     } catch (NumberFormatException numberFormatException) {
/*  284 */       return paramDouble;
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
/*      */   public static double toDouble(BigDecimal paramBigDecimal) {
/*  305 */     return toDouble(paramBigDecimal, 0.0D);
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
/*      */   public static double toDouble(BigDecimal paramBigDecimal, double paramDouble) {
/*  326 */     return (paramBigDecimal == null) ? paramDouble : paramBigDecimal.doubleValue();
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
/*      */   public static byte toByte(String paramString) {
/*  348 */     return toByte(paramString, (byte)0);
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
/*      */   public static byte toByte(String paramString, byte paramByte) {
/*  369 */     if (paramString == null) {
/*  370 */       return paramByte;
/*      */     }
/*      */     try {
/*  373 */       return Byte.parseByte(paramString);
/*  374 */     } catch (NumberFormatException numberFormatException) {
/*  375 */       return paramByte;
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
/*      */   public static short toShort(String paramString) {
/*  397 */     return toShort(paramString, (short)0);
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
/*      */   public static short toShort(String paramString, short paramShort) {
/*  418 */     if (paramString == null) {
/*  419 */       return paramShort;
/*      */     }
/*      */     try {
/*  422 */       return Short.parseShort(paramString);
/*  423 */     } catch (NumberFormatException numberFormatException) {
/*  424 */       return paramShort;
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
/*      */   public static BigDecimal toScaledBigDecimal(BigDecimal paramBigDecimal) {
/*  441 */     return toScaledBigDecimal(paramBigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
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
/*      */   public static BigDecimal toScaledBigDecimal(BigDecimal paramBigDecimal, int paramInt, RoundingMode paramRoundingMode) {
/*  457 */     if (paramBigDecimal == null) {
/*  458 */       return BigDecimal.ZERO;
/*      */     }
/*  460 */     return paramBigDecimal.setScale(paramInt, (paramRoundingMode == null) ? RoundingMode.HALF_EVEN : paramRoundingMode);
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
/*      */   public static BigDecimal toScaledBigDecimal(Float paramFloat) {
/*  479 */     return toScaledBigDecimal(paramFloat, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
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
/*      */   public static BigDecimal toScaledBigDecimal(Float paramFloat, int paramInt, RoundingMode paramRoundingMode) {
/*  495 */     if (paramFloat == null) {
/*  496 */       return BigDecimal.ZERO;
/*      */     }
/*  498 */     return toScaledBigDecimal(
/*  499 */         BigDecimal.valueOf(paramFloat.floatValue()), paramInt, paramRoundingMode);
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
/*      */   public static BigDecimal toScaledBigDecimal(Double paramDouble) {
/*  518 */     return toScaledBigDecimal(paramDouble, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
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
/*      */   public static BigDecimal toScaledBigDecimal(Double paramDouble, int paramInt, RoundingMode paramRoundingMode) {
/*  534 */     if (paramDouble == null) {
/*  535 */       return BigDecimal.ZERO;
/*      */     }
/*  537 */     return toScaledBigDecimal(
/*  538 */         BigDecimal.valueOf(paramDouble.doubleValue()), paramInt, paramRoundingMode);
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
/*      */   public static BigDecimal toScaledBigDecimal(String paramString) {
/*  557 */     return toScaledBigDecimal(paramString, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
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
/*      */   public static BigDecimal toScaledBigDecimal(String paramString, int paramInt, RoundingMode paramRoundingMode) {
/*  573 */     if (paramString == null) {
/*  574 */       return BigDecimal.ZERO;
/*      */     }
/*  576 */     return toScaledBigDecimal(
/*  577 */         createBigDecimal(paramString), paramInt, paramRoundingMode);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Number createNumber(String paramString) {
/*      */     String str1;
/*      */     Object object;
/*      */     String str2;
/*  651 */     if (paramString == null) {
/*  652 */       return null;
/*      */     }
/*  654 */     if (StringUtils.isBlank(paramString)) {
/*  655 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*      */     
/*  658 */     String[] arrayOfString = { "0x", "0X", "-0x", "-0X", "#", "-#" };
/*  659 */     int i = 0;
/*  660 */     for (String null : arrayOfString) {
/*  661 */       if (paramString.startsWith(str2)) {
/*  662 */         i += str2.length();
/*      */         break;
/*      */       } 
/*      */     } 
/*  666 */     if (i > 0) {
/*  667 */       char c1 = Character.MIN_VALUE; int m;
/*  668 */       for (m = i; m < paramString.length(); ) {
/*  669 */         c1 = paramString.charAt(m);
/*  670 */         if (c1 == '0') {
/*  671 */           i++;
/*      */           
/*      */           m++;
/*      */         } 
/*      */       } 
/*  676 */       m = paramString.length() - i;
/*  677 */       if (m > 16 || (m == 16 && c1 > '7')) {
/*  678 */         return createBigInteger(paramString);
/*      */       }
/*  680 */       if (m > 8 || (m == 8 && c1 > '7')) {
/*  681 */         return createLong(paramString);
/*      */       }
/*  683 */       return createInteger(paramString);
/*      */     } 
/*  685 */     char c = paramString.charAt(paramString.length() - 1);
/*      */ 
/*      */ 
/*      */     
/*  689 */     int j = paramString.indexOf('.');
/*  690 */     int k = paramString.indexOf('e') + paramString.indexOf('E') + 1;
/*      */ 
/*      */ 
/*      */     
/*  694 */     if (j > -1) {
/*  695 */       if (k > -1) {
/*  696 */         if (k < j || k > paramString.length()) {
/*  697 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         }
/*  699 */         object = paramString.substring(j + 1, k);
/*      */       } else {
/*  701 */         object = paramString.substring(j + 1);
/*      */       } 
/*  703 */       str1 = getMantissa(paramString, j);
/*      */     } else {
/*  705 */       if (k > -1) {
/*  706 */         if (k > paramString.length()) {
/*  707 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         }
/*  709 */         str1 = getMantissa(paramString, k);
/*      */       } else {
/*  711 */         str1 = getMantissa(paramString);
/*      */       } 
/*  713 */       object = null;
/*      */     } 
/*  715 */     if (!Character.isDigit(c) && c != '.') {
/*  716 */       if (k > -1 && k < paramString.length() - 1) {
/*  717 */         str2 = paramString.substring(k + 1, paramString.length() - 1);
/*      */       } else {
/*  719 */         str2 = null;
/*      */       } 
/*      */       
/*  722 */       String str = paramString.substring(0, paramString.length() - 1);
/*  723 */       boolean bool1 = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/*  724 */       switch (c) {
/*      */         case 'L':
/*      */         case 'l':
/*  727 */           if (object == null && str2 == null && ((
/*      */             
/*  729 */             !str.isEmpty() && str.charAt(0) == '-' && isDigits(str.substring(1))) || isDigits(str))) {
/*      */             try {
/*  731 */               return createLong(str);
/*  732 */             } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */               
/*  735 */               return createBigInteger(str);
/*      */             } 
/*      */           }
/*  738 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         case 'F':
/*      */         case 'f':
/*      */           try {
/*  742 */             Float float_ = createFloat(paramString);
/*  743 */             if (!float_.isInfinite() && (float_.floatValue() != 0.0F || bool1))
/*      */             {
/*      */               
/*  746 */               return float_;
/*      */             }
/*      */           }
/*  749 */           catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */         
/*      */         case 'D':
/*      */         case 'd':
/*      */           try {
/*  756 */             Double double_ = createDouble(paramString);
/*  757 */             if (!double_.isInfinite() && (double_.floatValue() != 0.0D || bool1)) {
/*  758 */               return double_;
/*      */             }
/*  760 */           } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */           
/*      */           try {
/*  764 */             return createBigDecimal(str);
/*  765 */           } catch (NumberFormatException numberFormatException) {
/*      */             break;
/*      */           } 
/*      */       } 
/*      */       
/*  770 */       throw new NumberFormatException(paramString + " is not a valid number.");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  776 */     if (k > -1 && k < paramString.length() - 1) {
/*  777 */       str2 = paramString.substring(k + 1, paramString.length());
/*      */     } else {
/*  779 */       str2 = null;
/*      */     } 
/*  781 */     if (object == null && str2 == null) {
/*      */       
/*      */       try {
/*  784 */         return createInteger(paramString);
/*  785 */       } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */         
/*      */         try {
/*  789 */           return createLong(paramString);
/*  790 */         } catch (NumberFormatException numberFormatException1) {
/*      */ 
/*      */           
/*  793 */           return createBigInteger(paramString);
/*      */         } 
/*      */       } 
/*      */     }
/*  797 */     boolean bool = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/*      */     try {
/*  799 */       Float float_ = createFloat(paramString);
/*  800 */       Double double_ = createDouble(paramString);
/*  801 */       if (!float_.isInfinite() && (float_
/*  802 */         .floatValue() != 0.0F || bool) && float_
/*  803 */         .toString().equals(double_.toString())) {
/*  804 */         return float_;
/*      */       }
/*  806 */       if (!double_.isInfinite() && (double_.doubleValue() != 0.0D || bool)) {
/*  807 */         BigDecimal bigDecimal = createBigDecimal(paramString);
/*  808 */         if (bigDecimal.compareTo(BigDecimal.valueOf(double_.doubleValue())) == 0) {
/*  809 */           return double_;
/*      */         }
/*  811 */         return bigDecimal;
/*      */       } 
/*  813 */     } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */     
/*  816 */     return createBigDecimal(paramString);
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
/*      */   private static String getMantissa(String paramString) {
/*  828 */     return getMantissa(paramString, paramString.length());
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
/*      */   private static String getMantissa(String paramString, int paramInt) {
/*  841 */     char c = paramString.charAt(0);
/*  842 */     boolean bool = (c == '-' || c == '+') ? true : false;
/*      */     
/*  844 */     return bool ? paramString.substring(1, paramInt) : paramString.substring(0, paramInt);
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
/*      */   private static boolean isAllZeros(String paramString) {
/*  856 */     if (paramString == null) {
/*  857 */       return true;
/*      */     }
/*  859 */     for (int i = paramString.length() - 1; i >= 0; i--) {
/*  860 */       if (paramString.charAt(i) != '0') {
/*  861 */         return false;
/*      */       }
/*      */     } 
/*  864 */     return !paramString.isEmpty();
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
/*      */   public static Float createFloat(String paramString) {
/*  878 */     if (paramString == null) {
/*  879 */       return null;
/*      */     }
/*  881 */     return Float.valueOf(paramString);
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
/*      */   public static Double createDouble(String paramString) {
/*  894 */     if (paramString == null) {
/*  895 */       return null;
/*      */     }
/*  897 */     return Double.valueOf(paramString);
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
/*      */   public static Integer createInteger(String paramString) {
/*  912 */     if (paramString == null) {
/*  913 */       return null;
/*      */     }
/*      */     
/*  916 */     return Integer.decode(paramString);
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
/*      */   public static Long createLong(String paramString) {
/*  931 */     if (paramString == null) {
/*  932 */       return null;
/*      */     }
/*  934 */     return Long.decode(paramString);
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
/*      */   public static BigInteger createBigInteger(String paramString) {
/*  948 */     if (paramString == null) {
/*  949 */       return null;
/*      */     }
/*  951 */     byte b1 = 0;
/*  952 */     byte b2 = 10;
/*  953 */     boolean bool = false;
/*  954 */     if (paramString.startsWith("-")) {
/*  955 */       bool = true;
/*  956 */       b1 = 1;
/*      */     } 
/*  958 */     if (paramString.startsWith("0x", b1) || paramString.startsWith("0X", b1)) {
/*  959 */       b2 = 16;
/*  960 */       b1 += true;
/*  961 */     } else if (paramString.startsWith("#", b1)) {
/*  962 */       b2 = 16;
/*  963 */       b1++;
/*  964 */     } else if (paramString.startsWith("0", b1) && paramString.length() > b1 + 1) {
/*  965 */       b2 = 8;
/*  966 */       b1++;
/*      */     } 
/*      */     
/*  969 */     BigInteger bigInteger = new BigInteger(paramString.substring(b1), b2);
/*  970 */     return bool ? bigInteger.negate() : bigInteger;
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
/*      */   public static BigDecimal createBigDecimal(String paramString) {
/*  983 */     if (paramString == null) {
/*  984 */       return null;
/*      */     }
/*      */     
/*  987 */     if (StringUtils.isBlank(paramString)) {
/*  988 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*  990 */     return new BigDecimal(paramString);
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
/*      */   public static long min(long... paramVarArgs) {
/* 1006 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1009 */     long l = paramVarArgs[0];
/* 1010 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1011 */       if (paramVarArgs[b] < l) {
/* 1012 */         l = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1016 */     return l;
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
/*      */   public static int min(int... paramVarArgs) {
/* 1030 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1033 */     int i = paramVarArgs[0];
/* 1034 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1035 */       if (paramVarArgs[b] < i) {
/* 1036 */         i = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1040 */     return i;
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
/*      */   public static short min(short... paramVarArgs) {
/* 1054 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1057 */     short s = paramVarArgs[0];
/* 1058 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1059 */       if (paramVarArgs[b] < s) {
/* 1060 */         s = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1064 */     return s;
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
/*      */   public static byte min(byte... paramVarArgs) {
/* 1078 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1081 */     byte b = paramVarArgs[0];
/* 1082 */     for (byte b1 = 1; b1 < paramVarArgs.length; b1++) {
/* 1083 */       if (paramVarArgs[b1] < b) {
/* 1084 */         b = paramVarArgs[b1];
/*      */       }
/*      */     } 
/*      */     
/* 1088 */     return b;
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
/*      */   public static double min(double... paramVarArgs) {
/* 1103 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1106 */     double d = paramVarArgs[0];
/* 1107 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1108 */       if (Double.isNaN(paramVarArgs[b])) {
/* 1109 */         return Double.NaN;
/*      */       }
/* 1111 */       if (paramVarArgs[b] < d) {
/* 1112 */         d = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1116 */     return d;
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
/*      */   public static float min(float... paramVarArgs) {
/* 1131 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1134 */     float f = paramVarArgs[0];
/* 1135 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1136 */       if (Float.isNaN(paramVarArgs[b])) {
/* 1137 */         return Float.NaN;
/*      */       }
/* 1139 */       if (paramVarArgs[b] < f) {
/* 1140 */         f = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1144 */     return f;
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
/*      */   public static long max(long... paramVarArgs) {
/* 1160 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1163 */     long l = paramVarArgs[0];
/* 1164 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1165 */       if (paramVarArgs[b] > l) {
/* 1166 */         l = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1170 */     return l;
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
/*      */   public static int max(int... paramVarArgs) {
/* 1184 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1187 */     int i = paramVarArgs[0];
/* 1188 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1189 */       if (paramVarArgs[b] > i) {
/* 1190 */         i = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1194 */     return i;
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
/*      */   public static short max(short... paramVarArgs) {
/* 1208 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1211 */     short s = paramVarArgs[0];
/* 1212 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1213 */       if (paramVarArgs[b] > s) {
/* 1214 */         s = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1218 */     return s;
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
/*      */   public static byte max(byte... paramVarArgs) {
/* 1232 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1235 */     byte b = paramVarArgs[0];
/* 1236 */     for (byte b1 = 1; b1 < paramVarArgs.length; b1++) {
/* 1237 */       if (paramVarArgs[b1] > b) {
/* 1238 */         b = paramVarArgs[b1];
/*      */       }
/*      */     } 
/*      */     
/* 1242 */     return b;
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
/*      */   public static double max(double... paramVarArgs) {
/* 1257 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1260 */     double d = paramVarArgs[0];
/* 1261 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1262 */       if (Double.isNaN(paramVarArgs[b])) {
/* 1263 */         return Double.NaN;
/*      */       }
/* 1265 */       if (paramVarArgs[b] > d) {
/* 1266 */         d = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1270 */     return d;
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
/*      */   public static float max(float... paramVarArgs) {
/* 1285 */     validateArray(paramVarArgs);
/*      */ 
/*      */     
/* 1288 */     float f = paramVarArgs[0];
/* 1289 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1290 */       if (Float.isNaN(paramVarArgs[b])) {
/* 1291 */         return Float.NaN;
/*      */       }
/* 1293 */       if (paramVarArgs[b] > f) {
/* 1294 */         f = paramVarArgs[b];
/*      */       }
/*      */     } 
/*      */     
/* 1298 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void validateArray(Object paramObject) {
/* 1308 */     Validate.notNull(paramObject, "The Array must not be null", new Object[0]);
/* 1309 */     Validate.isTrue((Array.getLength(paramObject) != 0), "Array cannot be empty.", new Object[0]);
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
/*      */   public static long min(long paramLong1, long paramLong2, long paramLong3) {
/* 1323 */     if (paramLong2 < paramLong1) {
/* 1324 */       paramLong1 = paramLong2;
/*      */     }
/* 1326 */     if (paramLong3 < paramLong1) {
/* 1327 */       paramLong1 = paramLong3;
/*      */     }
/* 1329 */     return paramLong1;
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
/*      */   public static int min(int paramInt1, int paramInt2, int paramInt3) {
/* 1341 */     if (paramInt2 < paramInt1) {
/* 1342 */       paramInt1 = paramInt2;
/*      */     }
/* 1344 */     if (paramInt3 < paramInt1) {
/* 1345 */       paramInt1 = paramInt3;
/*      */     }
/* 1347 */     return paramInt1;
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
/*      */   public static short min(short paramShort1, short paramShort2, short paramShort3) {
/* 1359 */     if (paramShort2 < paramShort1) {
/* 1360 */       paramShort1 = paramShort2;
/*      */     }
/* 1362 */     if (paramShort3 < paramShort1) {
/* 1363 */       paramShort1 = paramShort3;
/*      */     }
/* 1365 */     return paramShort1;
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
/*      */   public static byte min(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 1377 */     if (paramByte2 < paramByte1) {
/* 1378 */       paramByte1 = paramByte2;
/*      */     }
/* 1380 */     if (paramByte3 < paramByte1) {
/* 1381 */       paramByte1 = paramByte3;
/*      */     }
/* 1383 */     return paramByte1;
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
/*      */   public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1399 */     return Math.min(Math.min(paramDouble1, paramDouble2), paramDouble3);
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
/*      */   public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1415 */     return Math.min(Math.min(paramFloat1, paramFloat2), paramFloat3);
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
/*      */   public static long max(long paramLong1, long paramLong2, long paramLong3) {
/* 1429 */     if (paramLong2 > paramLong1) {
/* 1430 */       paramLong1 = paramLong2;
/*      */     }
/* 1432 */     if (paramLong3 > paramLong1) {
/* 1433 */       paramLong1 = paramLong3;
/*      */     }
/* 1435 */     return paramLong1;
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
/*      */   public static int max(int paramInt1, int paramInt2, int paramInt3) {
/* 1447 */     if (paramInt2 > paramInt1) {
/* 1448 */       paramInt1 = paramInt2;
/*      */     }
/* 1450 */     if (paramInt3 > paramInt1) {
/* 1451 */       paramInt1 = paramInt3;
/*      */     }
/* 1453 */     return paramInt1;
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
/*      */   public static short max(short paramShort1, short paramShort2, short paramShort3) {
/* 1465 */     if (paramShort2 > paramShort1) {
/* 1466 */       paramShort1 = paramShort2;
/*      */     }
/* 1468 */     if (paramShort3 > paramShort1) {
/* 1469 */       paramShort1 = paramShort3;
/*      */     }
/* 1471 */     return paramShort1;
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
/*      */   public static byte max(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 1483 */     if (paramByte2 > paramByte1) {
/* 1484 */       paramByte1 = paramByte2;
/*      */     }
/* 1486 */     if (paramByte3 > paramByte1) {
/* 1487 */       paramByte1 = paramByte3;
/*      */     }
/* 1489 */     return paramByte1;
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
/*      */   public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1505 */     return Math.max(Math.max(paramDouble1, paramDouble2), paramDouble3);
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
/*      */   public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1521 */     return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
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
/*      */   public static boolean isDigits(String paramString) {
/* 1536 */     return StringUtils.isNumeric(paramString);
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
/*      */   @Deprecated
/*      */   public static boolean isNumber(String paramString) {
/* 1566 */     return isCreatable(paramString);
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
/*      */   public static boolean isCreatable(String paramString) {
/* 1592 */     if (StringUtils.isEmpty(paramString)) {
/* 1593 */       return false;
/*      */     }
/* 1595 */     char[] arrayOfChar = paramString.toCharArray();
/* 1596 */     int i = arrayOfChar.length;
/* 1597 */     boolean bool1 = false;
/* 1598 */     boolean bool2 = false;
/* 1599 */     boolean bool3 = false;
/* 1600 */     boolean bool4 = false;
/*      */     
/* 1602 */     byte b1 = (arrayOfChar[0] == '-' || arrayOfChar[0] == '+') ? 1 : 0;
/* 1603 */     if (i > b1 + 1 && arrayOfChar[b1] == '0' && !StringUtils.contains(paramString, 46)) {
/* 1604 */       if (arrayOfChar[b1 + 1] == 'x' || arrayOfChar[b1 + 1] == 'X') {
/* 1605 */         int j = b1 + 2;
/* 1606 */         if (j == i) {
/* 1607 */           return false;
/*      */         }
/*      */         
/* 1610 */         for (; j < arrayOfChar.length; j++) {
/* 1611 */           if ((arrayOfChar[j] < '0' || arrayOfChar[j] > '9') && (arrayOfChar[j] < 'a' || arrayOfChar[j] > 'f') && (arrayOfChar[j] < 'A' || arrayOfChar[j] > 'F'))
/*      */           {
/*      */             
/* 1614 */             return false;
/*      */           }
/*      */         } 
/* 1617 */         return true;
/* 1618 */       }  if (Character.isDigit(arrayOfChar[b1 + 1])) {
/*      */         
/* 1620 */         int j = b1 + 1;
/* 1621 */         for (; j < arrayOfChar.length; j++) {
/* 1622 */           if (arrayOfChar[j] < '0' || arrayOfChar[j] > '7') {
/* 1623 */             return false;
/*      */           }
/*      */         } 
/* 1626 */         return true;
/*      */       } 
/*      */     } 
/* 1629 */     i--;
/*      */     
/* 1631 */     byte b2 = b1;
/*      */ 
/*      */     
/* 1634 */     while (b2 < i || (b2 < i + 1 && bool3 && !bool4)) {
/* 1635 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9') {
/* 1636 */         bool4 = true;
/* 1637 */         bool3 = false;
/*      */       }
/* 1639 */       else if (arrayOfChar[b2] == '.') {
/* 1640 */         if (bool2 || bool1)
/*      */         {
/* 1642 */           return false;
/*      */         }
/* 1644 */         bool2 = true;
/* 1645 */       } else if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E') {
/*      */         
/* 1647 */         if (bool1)
/*      */         {
/* 1649 */           return false;
/*      */         }
/* 1651 */         if (!bool4) {
/* 1652 */           return false;
/*      */         }
/* 1654 */         bool1 = true;
/* 1655 */         bool3 = true;
/* 1656 */       } else if (arrayOfChar[b2] == '+' || arrayOfChar[b2] == '-') {
/* 1657 */         if (!bool3) {
/* 1658 */           return false;
/*      */         }
/* 1660 */         bool3 = false;
/* 1661 */         bool4 = false;
/*      */       } else {
/* 1663 */         return false;
/*      */       } 
/* 1665 */       b2++;
/*      */     } 
/* 1667 */     if (b2 < arrayOfChar.length) {
/* 1668 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9')
/*      */       {
/* 1670 */         return true;
/*      */       }
/* 1672 */       if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E')
/*      */       {
/* 1674 */         return false;
/*      */       }
/* 1676 */       if (arrayOfChar[b2] == '.') {
/* 1677 */         if (bool2 || bool1)
/*      */         {
/* 1679 */           return false;
/*      */         }
/*      */         
/* 1682 */         return bool4;
/*      */       } 
/* 1684 */       if (!bool3 && (arrayOfChar[b2] == 'd' || arrayOfChar[b2] == 'D' || arrayOfChar[b2] == 'f' || arrayOfChar[b2] == 'F'))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1689 */         return bool4;
/*      */       }
/* 1691 */       if (arrayOfChar[b2] == 'l' || arrayOfChar[b2] == 'L')
/*      */       {
/*      */         
/* 1694 */         return (bool4 && !bool1 && !bool2);
/*      */       }
/*      */       
/* 1697 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1701 */     return (!bool3 && bool4);
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
/*      */   public static boolean isParsable(String paramString) {
/* 1722 */     if (StringUtils.isEmpty(paramString)) {
/* 1723 */       return false;
/*      */     }
/* 1725 */     if (paramString.charAt(paramString.length() - 1) == '.') {
/* 1726 */       return false;
/*      */     }
/* 1728 */     if (paramString.charAt(0) == '-') {
/* 1729 */       if (paramString.length() == 1) {
/* 1730 */         return false;
/*      */       }
/* 1732 */       return withDecimalsParsing(paramString, 1);
/*      */     } 
/* 1734 */     return withDecimalsParsing(paramString, 0);
/*      */   }
/*      */   
/*      */   private static boolean withDecimalsParsing(String paramString, int paramInt) {
/* 1738 */     byte b = 0;
/* 1739 */     for (int i = paramInt; i < paramString.length(); i++) {
/* 1740 */       boolean bool = (paramString.charAt(i) == '.') ? true : false;
/* 1741 */       if (bool) {
/* 1742 */         b++;
/*      */       }
/* 1744 */       if (b > 1) {
/* 1745 */         return false;
/*      */       }
/* 1747 */       if (!bool && !Character.isDigit(paramString.charAt(i))) {
/* 1748 */         return false;
/*      */       }
/*      */     } 
/* 1751 */     return true;
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
/*      */   public static int compare(int paramInt1, int paramInt2) {
/* 1765 */     if (paramInt1 == paramInt2) {
/* 1766 */       return 0;
/*      */     }
/* 1768 */     return (paramInt1 < paramInt2) ? -1 : 1;
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
/*      */   public static int compare(long paramLong1, long paramLong2) {
/* 1782 */     if (paramLong1 == paramLong2) {
/* 1783 */       return 0;
/*      */     }
/* 1785 */     return (paramLong1 < paramLong2) ? -1 : 1;
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
/*      */   public static int compare(short paramShort1, short paramShort2) {
/* 1799 */     if (paramShort1 == paramShort2) {
/* 1800 */       return 0;
/*      */     }
/* 1802 */     return (paramShort1 < paramShort2) ? -1 : 1;
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
/*      */   public static int compare(byte paramByte1, byte paramByte2) {
/* 1816 */     return paramByte1 - paramByte2;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\math\NumberUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */