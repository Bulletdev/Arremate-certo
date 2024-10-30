/*      */ package org.apache.commons.collections4;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayDeque;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Deque;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.ResourceBundle;
/*      */ import java.util.SortedMap;
/*      */ import java.util.TreeMap;
/*      */ import org.apache.commons.collections4.map.AbstractMapDecorator;
/*      */ import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
/*      */ import org.apache.commons.collections4.map.FixedSizeMap;
/*      */ import org.apache.commons.collections4.map.FixedSizeSortedMap;
/*      */ import org.apache.commons.collections4.map.LazyMap;
/*      */ import org.apache.commons.collections4.map.LazySortedMap;
/*      */ import org.apache.commons.collections4.map.ListOrderedMap;
/*      */ import org.apache.commons.collections4.map.MultiValueMap;
/*      */ import org.apache.commons.collections4.map.PredicatedMap;
/*      */ import org.apache.commons.collections4.map.PredicatedSortedMap;
/*      */ import org.apache.commons.collections4.map.TransformedMap;
/*      */ import org.apache.commons.collections4.map.TransformedSortedMap;
/*      */ import org.apache.commons.collections4.map.UnmodifiableMap;
/*      */ import org.apache.commons.collections4.map.UnmodifiableSortedMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MapUtils
/*      */ {
/*   87 */   public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap<Object, Object>());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String INDENT_STRING = "    ";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> V getObject(Map<? super K, V> paramMap, K paramK) {
/*  112 */     if (paramMap != null) {
/*  113 */       return paramMap.get(paramK);
/*      */     }
/*  115 */     return null;
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
/*      */   public static <K> String getString(Map<? super K, ?> paramMap, K paramK) {
/*  129 */     if (paramMap != null) {
/*  130 */       Object object = paramMap.get(paramK);
/*  131 */       if (object != null) {
/*  132 */         return object.toString();
/*      */       }
/*      */     } 
/*  135 */     return null;
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
/*      */   public static <K> Boolean getBoolean(Map<? super K, ?> paramMap, K paramK) {
/*  154 */     if (paramMap != null) {
/*  155 */       Object object = paramMap.get(paramK);
/*  156 */       if (object != null) {
/*  157 */         if (object instanceof Boolean) {
/*  158 */           return (Boolean)object;
/*      */         }
/*  160 */         if (object instanceof String) {
/*  161 */           return Boolean.valueOf((String)object);
/*      */         }
/*  163 */         if (object instanceof Number) {
/*  164 */           Number number = (Number)object;
/*  165 */           return (number.intValue() != 0) ? Boolean.TRUE : Boolean.FALSE;
/*      */         } 
/*      */       } 
/*      */     } 
/*  169 */     return null;
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
/*      */   public static <K> Number getNumber(Map<? super K, ?> paramMap, K paramK) {
/*  187 */     if (paramMap != null) {
/*  188 */       Object object = paramMap.get(paramK);
/*  189 */       if (object != null) {
/*  190 */         if (object instanceof Number) {
/*  191 */           return (Number)object;
/*      */         }
/*  193 */         if (object instanceof String) {
/*      */           try {
/*  195 */             String str = (String)object;
/*  196 */             return NumberFormat.getInstance().parse(str);
/*  197 */           } catch (ParseException parseException) {}
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  203 */     return null;
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
/*      */   public static <K> Byte getByte(Map<? super K, ?> paramMap, K paramK) {
/*  217 */     Number number = getNumber(paramMap, paramK);
/*  218 */     if (number == null) {
/*  219 */       return null;
/*      */     }
/*  221 */     if (number instanceof Byte) {
/*  222 */       return (Byte)number;
/*      */     }
/*  224 */     return Byte.valueOf(number.byteValue());
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
/*      */   public static <K> Short getShort(Map<? super K, ?> paramMap, K paramK) {
/*  238 */     Number number = getNumber(paramMap, paramK);
/*  239 */     if (number == null) {
/*  240 */       return null;
/*      */     }
/*  242 */     if (number instanceof Short) {
/*  243 */       return (Short)number;
/*      */     }
/*  245 */     return Short.valueOf(number.shortValue());
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
/*      */   public static <K> Integer getInteger(Map<? super K, ?> paramMap, K paramK) {
/*  259 */     Number number = getNumber(paramMap, paramK);
/*  260 */     if (number == null) {
/*  261 */       return null;
/*      */     }
/*  263 */     if (number instanceof Integer) {
/*  264 */       return (Integer)number;
/*      */     }
/*  266 */     return Integer.valueOf(number.intValue());
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
/*      */   public static <K> Long getLong(Map<? super K, ?> paramMap, K paramK) {
/*  280 */     Number number = getNumber(paramMap, paramK);
/*  281 */     if (number == null) {
/*  282 */       return null;
/*      */     }
/*  284 */     if (number instanceof Long) {
/*  285 */       return (Long)number;
/*      */     }
/*  287 */     return Long.valueOf(number.longValue());
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
/*      */   public static <K> Float getFloat(Map<? super K, ?> paramMap, K paramK) {
/*  301 */     Number number = getNumber(paramMap, paramK);
/*  302 */     if (number == null) {
/*  303 */       return null;
/*      */     }
/*  305 */     if (number instanceof Float) {
/*  306 */       return (Float)number;
/*      */     }
/*  308 */     return Float.valueOf(number.floatValue());
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
/*      */   public static <K> Double getDouble(Map<? super K, ?> paramMap, K paramK) {
/*  322 */     Number number = getNumber(paramMap, paramK);
/*  323 */     if (number == null) {
/*  324 */       return null;
/*      */     }
/*  326 */     if (number instanceof Double) {
/*  327 */       return (Double)number;
/*      */     }
/*  329 */     return Double.valueOf(number.doubleValue());
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
/*      */   public static <K> Map<?, ?> getMap(Map<? super K, ?> paramMap, K paramK) {
/*  344 */     if (paramMap != null) {
/*  345 */       Object object = paramMap.get(paramK);
/*  346 */       if (object != null && object instanceof Map) {
/*  347 */         return (Map<?, ?>)object;
/*      */       }
/*      */     } 
/*  350 */     return null;
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
/*      */   public static <K, V> V getObject(Map<K, V> paramMap, K paramK, V paramV) {
/*  368 */     if (paramMap != null) {
/*  369 */       V v = paramMap.get(paramK);
/*  370 */       if (v != null) {
/*  371 */         return v;
/*      */       }
/*      */     } 
/*  374 */     return paramV;
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
/*      */   public static <K> String getString(Map<? super K, ?> paramMap, K paramK, String paramString) {
/*  390 */     String str = getString(paramMap, paramK);
/*  391 */     if (str == null) {
/*  392 */       str = paramString;
/*      */     }
/*  394 */     return str;
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
/*      */   public static <K> Boolean getBoolean(Map<? super K, ?> paramMap, K paramK, Boolean paramBoolean) {
/*  410 */     Boolean bool = getBoolean(paramMap, paramK);
/*  411 */     if (bool == null) {
/*  412 */       bool = paramBoolean;
/*      */     }
/*  414 */     return bool;
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
/*      */   public static <K> Number getNumber(Map<? super K, ?> paramMap, K paramK, Number paramNumber) {
/*  430 */     Number number = getNumber(paramMap, paramK);
/*  431 */     if (number == null) {
/*  432 */       number = paramNumber;
/*      */     }
/*  434 */     return number;
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
/*      */   public static <K> Byte getByte(Map<? super K, ?> paramMap, K paramK, Byte paramByte) {
/*  450 */     Byte byte_ = getByte(paramMap, paramK);
/*  451 */     if (byte_ == null) {
/*  452 */       byte_ = paramByte;
/*      */     }
/*  454 */     return byte_;
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
/*      */   public static <K> Short getShort(Map<? super K, ?> paramMap, K paramK, Short paramShort) {
/*  470 */     Short short_ = getShort(paramMap, paramK);
/*  471 */     if (short_ == null) {
/*  472 */       short_ = paramShort;
/*      */     }
/*  474 */     return short_;
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
/*      */   public static <K> Integer getInteger(Map<? super K, ?> paramMap, K paramK, Integer paramInteger) {
/*  490 */     Integer integer = getInteger(paramMap, paramK);
/*  491 */     if (integer == null) {
/*  492 */       integer = paramInteger;
/*      */     }
/*  494 */     return integer;
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
/*      */   public static <K> Long getLong(Map<? super K, ?> paramMap, K paramK, Long paramLong) {
/*  510 */     Long long_ = getLong(paramMap, paramK);
/*  511 */     if (long_ == null) {
/*  512 */       long_ = paramLong;
/*      */     }
/*  514 */     return long_;
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
/*      */   public static <K> Float getFloat(Map<? super K, ?> paramMap, K paramK, Float paramFloat) {
/*  530 */     Float float_ = getFloat(paramMap, paramK);
/*  531 */     if (float_ == null) {
/*  532 */       float_ = paramFloat;
/*      */     }
/*  534 */     return float_;
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
/*      */   public static <K> Double getDouble(Map<? super K, ?> paramMap, K paramK, Double paramDouble) {
/*  550 */     Double double_ = getDouble(paramMap, paramK);
/*  551 */     if (double_ == null) {
/*  552 */       double_ = paramDouble;
/*      */     }
/*  554 */     return double_;
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
/*      */   public static <K> Map<?, ?> getMap(Map<? super K, ?> paramMap, K paramK, Map<?, ?> paramMap1) {
/*  570 */     Map<?, ?> map = getMap(paramMap, paramK);
/*  571 */     if (map == null) {
/*  572 */       map = paramMap1;
/*      */     }
/*  574 */     return map;
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
/*      */   public static <K> boolean getBooleanValue(Map<? super K, ?> paramMap, K paramK) {
/*  595 */     return Boolean.TRUE.equals(getBoolean(paramMap, paramK));
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
/*      */   public static <K> byte getByteValue(Map<? super K, ?> paramMap, K paramK) {
/*  609 */     Byte byte_ = getByte(paramMap, paramK);
/*  610 */     if (byte_ == null) {
/*  611 */       return 0;
/*      */     }
/*  613 */     return byte_.byteValue();
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
/*      */   public static <K> short getShortValue(Map<? super K, ?> paramMap, K paramK) {
/*  627 */     Short short_ = getShort(paramMap, paramK);
/*  628 */     if (short_ == null) {
/*  629 */       return 0;
/*      */     }
/*  631 */     return short_.shortValue();
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
/*      */   public static <K> int getIntValue(Map<? super K, ?> paramMap, K paramK) {
/*  645 */     Integer integer = getInteger(paramMap, paramK);
/*  646 */     if (integer == null) {
/*  647 */       return 0;
/*      */     }
/*  649 */     return integer.intValue();
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
/*      */   public static <K> long getLongValue(Map<? super K, ?> paramMap, K paramK) {
/*  663 */     Long long_ = getLong(paramMap, paramK);
/*  664 */     if (long_ == null) {
/*  665 */       return 0L;
/*      */     }
/*  667 */     return long_.longValue();
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
/*      */   public static <K> float getFloatValue(Map<? super K, ?> paramMap, K paramK) {
/*  681 */     Float float_ = getFloat(paramMap, paramK);
/*  682 */     if (float_ == null) {
/*  683 */       return 0.0F;
/*      */     }
/*  685 */     return float_.floatValue();
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
/*      */   public static <K> double getDoubleValue(Map<? super K, ?> paramMap, K paramK) {
/*  699 */     Double double_ = getDouble(paramMap, paramK);
/*  700 */     if (double_ == null) {
/*  701 */       return 0.0D;
/*      */     }
/*  703 */     return double_.doubleValue();
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
/*      */   public static <K> boolean getBooleanValue(Map<? super K, ?> paramMap, K paramK, boolean paramBoolean) {
/*  726 */     Boolean bool = getBoolean(paramMap, paramK);
/*  727 */     if (bool == null) {
/*  728 */       return paramBoolean;
/*      */     }
/*  730 */     return bool.booleanValue();
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
/*      */   public static <K> byte getByteValue(Map<? super K, ?> paramMap, K paramK, byte paramByte) {
/*  746 */     Byte byte_ = getByte(paramMap, paramK);
/*  747 */     if (byte_ == null) {
/*  748 */       return paramByte;
/*      */     }
/*  750 */     return byte_.byteValue();
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
/*      */   public static <K> short getShortValue(Map<? super K, ?> paramMap, K paramK, short paramShort) {
/*  766 */     Short short_ = getShort(paramMap, paramK);
/*  767 */     if (short_ == null) {
/*  768 */       return paramShort;
/*      */     }
/*  770 */     return short_.shortValue();
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
/*      */   public static <K> int getIntValue(Map<? super K, ?> paramMap, K paramK, int paramInt) {
/*  786 */     Integer integer = getInteger(paramMap, paramK);
/*  787 */     if (integer == null) {
/*  788 */       return paramInt;
/*      */     }
/*  790 */     return integer.intValue();
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
/*      */   public static <K> long getLongValue(Map<? super K, ?> paramMap, K paramK, long paramLong) {
/*  806 */     Long long_ = getLong(paramMap, paramK);
/*  807 */     if (long_ == null) {
/*  808 */       return paramLong;
/*      */     }
/*  810 */     return long_.longValue();
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
/*      */   public static <K> float getFloatValue(Map<? super K, ?> paramMap, K paramK, float paramFloat) {
/*  826 */     Float float_ = getFloat(paramMap, paramK);
/*  827 */     if (float_ == null) {
/*  828 */       return paramFloat;
/*      */     }
/*  830 */     return float_.floatValue();
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
/*      */   public static <K> double getDoubleValue(Map<? super K, ?> paramMap, K paramK, double paramDouble) {
/*  846 */     Double double_ = getDouble(paramMap, paramK);
/*  847 */     if (double_ == null) {
/*  848 */       return paramDouble;
/*      */     }
/*  850 */     return double_.doubleValue();
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
/*      */   public static <K, V> Properties toProperties(Map<K, V> paramMap) {
/*  870 */     Properties properties = new Properties();
/*  871 */     if (paramMap != null) {
/*  872 */       for (Map.Entry<K, V> entry1 : paramMap.entrySet()) {
/*  873 */         Map.Entry<K, V> entry2 = entry1;
/*  874 */         Object object1 = entry2.getKey();
/*  875 */         Object object2 = entry2.getValue();
/*  876 */         properties.put(object1, object2);
/*      */       } 
/*      */     }
/*  879 */     return properties;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<String, Object> toMap(ResourceBundle paramResourceBundle) {
/*  890 */     Enumeration<String> enumeration = paramResourceBundle.getKeys();
/*  891 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*      */     
/*  893 */     while (enumeration.hasMoreElements()) {
/*  894 */       String str = enumeration.nextElement();
/*  895 */       Object object = paramResourceBundle.getObject(str);
/*  896 */       hashMap.put(str, object);
/*      */     } 
/*      */     
/*  899 */     return (Map)hashMap;
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
/*      */   public static void verbosePrint(PrintStream paramPrintStream, Object paramObject, Map<?, ?> paramMap) {
/*  923 */     verbosePrintInternal(paramPrintStream, paramObject, paramMap, new ArrayDeque<Map<?, ?>>(), false);
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
/*      */   public static void debugPrint(PrintStream paramPrintStream, Object paramObject, Map<?, ?> paramMap) {
/*  945 */     verbosePrintInternal(paramPrintStream, paramObject, paramMap, new ArrayDeque<Map<?, ?>>(), true);
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
/*      */   private static void verbosePrintInternal(PrintStream paramPrintStream, Object paramObject, Map<?, ?> paramMap, Deque<Map<?, ?>> paramDeque, boolean paramBoolean) {
/*  975 */     printIndent(paramPrintStream, paramDeque.size());
/*      */     
/*  977 */     if (paramMap == null) {
/*  978 */       if (paramObject != null) {
/*  979 */         paramPrintStream.print(paramObject);
/*  980 */         paramPrintStream.print(" = ");
/*      */       } 
/*  982 */       paramPrintStream.println("null");
/*      */       return;
/*      */     } 
/*  985 */     if (paramObject != null) {
/*  986 */       paramPrintStream.print(paramObject);
/*  987 */       paramPrintStream.println(" = ");
/*      */     } 
/*      */     
/*  990 */     printIndent(paramPrintStream, paramDeque.size());
/*  991 */     paramPrintStream.println("{");
/*      */     
/*  993 */     paramDeque.addLast(paramMap);
/*      */     
/*  995 */     for (Map.Entry<?, ?> entry : paramMap.entrySet()) {
/*  996 */       Object object1 = entry.getKey();
/*  997 */       Object object2 = entry.getValue();
/*  998 */       if (object2 instanceof Map && !paramDeque.contains(object2)) {
/*  999 */         verbosePrintInternal(paramPrintStream, (object1 == null) ? "null" : object1, (Map<?, ?>)object2, paramDeque, paramBoolean);
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/* 1006 */       printIndent(paramPrintStream, paramDeque.size());
/* 1007 */       paramPrintStream.print(object1);
/* 1008 */       paramPrintStream.print(" = ");
/*      */       
/* 1010 */       int i = IterableUtils.indexOf(paramDeque, PredicateUtils.equalPredicate(object2));
/*      */ 
/*      */       
/* 1013 */       if (i == -1) {
/* 1014 */         paramPrintStream.print(object2);
/* 1015 */       } else if (paramDeque.size() - 1 == i) {
/* 1016 */         paramPrintStream.print("(this Map)");
/*      */       } else {
/* 1018 */         paramPrintStream.print("(ancestor[" + (paramDeque.size() - 1 - i - 1) + "] Map)");
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1024 */       if (paramBoolean && object2 != null) {
/* 1025 */         paramPrintStream.print(' ');
/* 1026 */         paramPrintStream.println(object2.getClass().getName()); continue;
/*      */       } 
/* 1028 */       paramPrintStream.println();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1033 */     paramDeque.removeLast();
/*      */     
/* 1035 */     printIndent(paramPrintStream, paramDeque.size());
/* 1036 */     paramPrintStream.println(paramBoolean ? ("} " + paramMap.getClass().getName()) : "}");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void printIndent(PrintStream paramPrintStream, int paramInt) {
/* 1045 */     for (byte b = 0; b < paramInt; b++) {
/* 1046 */       paramPrintStream.print("    ");
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
/*      */   public static <K, V> Map<V, K> invertMap(Map<K, V> paramMap) {
/* 1068 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
/* 1069 */     for (Map.Entry<K, V> entry : paramMap.entrySet()) {
/* 1070 */       hashMap.put(entry.getValue(), entry.getKey());
/*      */     }
/* 1072 */     return (Map)hashMap;
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
/*      */   public static <K> void safeAddToMap(Map<? super K, Object> paramMap, K paramK, Object paramObject) throws NullPointerException {
/* 1098 */     paramMap.put(paramK, (paramObject == null) ? "" : paramObject);
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
/*      */   public static <K, V> Map<K, V> putAll(Map<K, V> paramMap, Object[] paramArrayOfObject) {
/* 1152 */     if (paramMap == null) {
/* 1153 */       throw new NullPointerException("The map must not be null");
/*      */     }
/* 1155 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 1156 */       return paramMap;
/*      */     }
/* 1158 */     Object object = paramArrayOfObject[0];
/* 1159 */     if (object instanceof Map.Entry) {
/* 1160 */       for (Object object1 : paramArrayOfObject) {
/*      */         
/* 1162 */         Map.Entry entry = (Map.Entry)object1;
/* 1163 */         paramMap.put((K)entry.getKey(), (V)entry.getValue());
/*      */       } 
/* 1165 */     } else if (object instanceof KeyValue) {
/* 1166 */       for (Object object1 : paramArrayOfObject) {
/*      */         
/* 1168 */         KeyValue keyValue = (KeyValue)object1;
/* 1169 */         paramMap.put((K)keyValue.getKey(), (V)keyValue.getValue());
/*      */       } 
/* 1171 */     } else if (object instanceof Object[]) {
/* 1172 */       for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 1173 */         Object[] arrayOfObject = (Object[])paramArrayOfObject[b];
/* 1174 */         if (arrayOfObject == null || arrayOfObject.length < 2) {
/* 1175 */           throw new IllegalArgumentException("Invalid array element: " + b);
/*      */         }
/*      */         
/* 1178 */         paramMap.put((K)arrayOfObject[0], (V)arrayOfObject[1]);
/*      */       } 
/*      */     } else {
/* 1181 */       for (byte b = 0; b < paramArrayOfObject.length - 1;)
/*      */       {
/* 1183 */         paramMap.put((K)paramArrayOfObject[b++], (V)paramArrayOfObject[b++]);
/*      */       }
/*      */     } 
/* 1186 */     return paramMap;
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
/*      */   public static <K, V> Map<K, V> emptyIfNull(Map<K, V> paramMap) {
/* 1201 */     return (paramMap == null) ? Collections.<K, V>emptyMap() : paramMap;
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
/*      */   public static boolean isEmpty(Map<?, ?> paramMap) {
/* 1214 */     return (paramMap == null || paramMap.isEmpty());
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
/*      */   public static boolean isNotEmpty(Map<?, ?> paramMap) {
/* 1227 */     return !isEmpty(paramMap);
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
/*      */   public static <K, V> Map<K, V> synchronizedMap(Map<K, V> paramMap) {
/* 1257 */     return Collections.synchronizedMap(paramMap);
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
/*      */   public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> paramMap) {
/* 1272 */     return UnmodifiableMap.unmodifiableMap(paramMap);
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
/*      */   public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/* 1294 */     return (IterableMap<K, V>)PredicatedMap.predicatedMap(paramMap, paramPredicate, paramPredicate1);
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
/*      */   public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> paramMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 1323 */     return (IterableMap<K, V>)TransformedMap.transformingMap(paramMap, paramTransformer, paramTransformer1);
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
/*      */   public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> paramMap) {
/* 1339 */     return (IterableMap<K, V>)FixedSizeMap.fixedSizeMap(paramMap);
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
/*      */   public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> paramMap, Factory<? extends V> paramFactory) {
/* 1373 */     return (IterableMap<K, V>)LazyMap.lazyMap(paramMap, paramFactory);
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
/*      */   public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> paramMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 1415 */     return (IterableMap<K, V>)LazyMap.lazyMap(paramMap, paramTransformer);
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
/*      */   public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> paramMap) {
/* 1432 */     return (OrderedMap<K, V>)ListOrderedMap.listOrderedMap(paramMap);
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
/*      */   @Deprecated
/*      */   public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> paramMap) {
/* 1449 */     return MultiValueMap.multiValueMap(paramMap);
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
/*      */   @Deprecated
/*      */   public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> paramMap, Class<C> paramClass) {
/* 1470 */     return MultiValueMap.multiValueMap(paramMap, paramClass);
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
/*      */   @Deprecated
/*      */   public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> paramMap, Factory<C> paramFactory) {
/* 1491 */     return MultiValueMap.multiValueMap(paramMap, paramFactory);
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
/*      */   public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> paramSortedMap) {
/* 1522 */     return Collections.synchronizedSortedMap(paramSortedMap);
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
/*      */   public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> paramSortedMap) {
/* 1537 */     return UnmodifiableSortedMap.unmodifiableSortedMap(paramSortedMap);
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
/*      */   public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/* 1559 */     return (SortedMap<K, V>)PredicatedSortedMap.predicatedSortedMap(paramSortedMap, paramPredicate, paramPredicate1);
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
/*      */   public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 1588 */     return (SortedMap<K, V>)TransformedSortedMap.transformingSortedMap(paramSortedMap, paramTransformer, paramTransformer1);
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
/*      */   public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> paramSortedMap) {
/* 1604 */     return (SortedMap<K, V>)FixedSizeSortedMap.fixedSizeSortedMap(paramSortedMap);
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
/*      */   public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> paramSortedMap, Factory<? extends V> paramFactory) {
/* 1639 */     return (SortedMap<K, V>)LazySortedMap.lazySortedMap(paramSortedMap, paramFactory);
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
/*      */   public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> paramSortedMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 1681 */     return (SortedMap<K, V>)LazySortedMap.lazySortedMap(paramSortedMap, paramTransformer);
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
/*      */   public static <K, V> void populateMap(Map<K, V> paramMap, Iterable<? extends V> paramIterable, Transformer<V, K> paramTransformer) {
/* 1697 */     populateMap(paramMap, paramIterable, paramTransformer, TransformerUtils.nopTransformer());
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
/*      */   public static <K, V, E> void populateMap(Map<K, V> paramMap, Iterable<? extends E> paramIterable, Transformer<E, K> paramTransformer, Transformer<E, V> paramTransformer1) {
/* 1716 */     Iterator<? extends E> iterator = paramIterable.iterator();
/* 1717 */     while (iterator.hasNext()) {
/* 1718 */       E e = iterator.next();
/* 1719 */       paramMap.put(paramTransformer.transform(e), paramTransformer1.transform(e));
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
/*      */   public static <K, V> void populateMap(MultiMap<K, V> paramMultiMap, Iterable<? extends V> paramIterable, Transformer<V, K> paramTransformer) {
/* 1736 */     populateMap(paramMultiMap, paramIterable, paramTransformer, TransformerUtils.nopTransformer());
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
/*      */   public static <K, V, E> void populateMap(MultiMap<K, V> paramMultiMap, Iterable<? extends E> paramIterable, Transformer<E, K> paramTransformer, Transformer<E, V> paramTransformer1) {
/* 1755 */     Iterator<? extends E> iterator = paramIterable.iterator();
/* 1756 */     while (iterator.hasNext()) {
/* 1757 */       E e = iterator.next();
/* 1758 */       paramMultiMap.put(paramTransformer.transform(e), paramTransformer1.transform(e));
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
/*      */   public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> paramMap) {
/* 1773 */     if (paramMap == null) {
/* 1774 */       throw new NullPointerException("Map must not be null");
/*      */     }
/* 1776 */     return (paramMap instanceof IterableMap) ? (IterableMap<K, V>)paramMap : (IterableMap<K, V>)new AbstractMapDecorator<K, V>(paramMap)
/*      */       {
/*      */       
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> paramSortedMap) {
/* 1790 */     if (paramSortedMap == null) {
/* 1791 */       throw new NullPointerException("Map must not be null");
/*      */     }
/* 1793 */     return (paramSortedMap instanceof IterableSortedMap) ? (IterableSortedMap<K, V>)paramSortedMap : (IterableSortedMap<K, V>)new AbstractSortedMapDecorator<K, V>(paramSortedMap) {
/*      */       
/*      */       };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */