/*     */ package oshi.driver.unix;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSDesktopWindow;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class Xwininfo
/*     */ {
/*  48 */   private static final String[] NET_CLIENT_LIST_STACKING = ParseUtil.whitespaces
/*  49 */     .split("xprop -root _NET_CLIENT_LIST_STACKING");
/*  50 */   private static final String[] XWININFO_ROOT_TREE = ParseUtil.whitespaces.split("xwininfo -root -tree");
/*  51 */   private static final String[] XPROP_NET_WM_PID_ID = ParseUtil.whitespaces.split("xprop _NET_WM_PID -id");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<OSDesktopWindow> queryXWindows(boolean paramBoolean) {
/*  72 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  73 */     byte b = 0;
/*     */ 
/*     */     
/*  76 */     List<String> list = ExecutingCommand.runNative(NET_CLIENT_LIST_STACKING, null);
/*  77 */     if (!list.isEmpty()) {
/*  78 */       String str = list.get(0);
/*  79 */       int i = str.indexOf("0x");
/*  80 */       if (i >= 0) {
/*  81 */         for (String str1 : str.substring(i).split(", ")) {
/*  82 */           hashMap1.put(str1, Integer.valueOf(++b));
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/*  87 */     Pattern pattern = Pattern.compile("(0x\\S+) (?:\"(.+)\")?.*: \\((?:\"(.+)\" \".+\")?\\)  (\\d+)x(\\d+)\\+.+  \\+(-?\\d+)\\+(-?\\d+)");
/*     */     
/*  89 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  90 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*     */     
/*  92 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */     
/*  94 */     for (String str : ExecutingCommand.runNative(XWININFO_ROOT_TREE, null)) {
/*  95 */       Matcher matcher = pattern.matcher(str.trim());
/*  96 */       if (matcher.matches()) {
/*  97 */         String str1 = matcher.group(1);
/*  98 */         if (!paramBoolean || hashMap1.containsKey(str1)) {
/*  99 */           String str2 = matcher.group(2);
/* 100 */           if (!Util.isBlank(str2)) {
/* 101 */             hashMap2.put(str1, str2);
/*     */           }
/* 103 */           String str3 = matcher.group(3);
/* 104 */           if (!Util.isBlank(str3)) {
/* 105 */             hashMap3.put(str1, str3);
/*     */           }
/* 107 */           linkedHashMap.put(str1, new Rectangle(ParseUtil.parseIntOrDefault(matcher.group(6), 0), 
/* 108 */                 ParseUtil.parseIntOrDefault(matcher.group(7), 0), ParseUtil.parseIntOrDefault(matcher.group(4), 0), 
/* 109 */                 ParseUtil.parseIntOrDefault(matcher.group(5), 0)));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 115 */     ArrayList<OSDesktopWindow> arrayList = new ArrayList();
/* 116 */     for (Map.Entry<Object, Object> entry : linkedHashMap.entrySet()) {
/* 117 */       String str = (String)entry.getKey();
/* 118 */       long l = queryPidFromId(str);
/* 119 */       boolean bool = hashMap1.containsKey(str);
/* 120 */       arrayList.add(new OSDesktopWindow(ParseUtil.hexStringToLong(str, 0L), (String)hashMap2.getOrDefault(str, ""), (String)hashMap3
/* 121 */             .getOrDefault(str, ""), (Rectangle)entry.getValue(), l, ((Integer)hashMap1.getOrDefault(str, Integer.valueOf(0))).intValue(), bool));
/*     */     } 
/* 123 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static long queryPidFromId(String paramString) {
/* 128 */     String[] arrayOfString = new String[XPROP_NET_WM_PID_ID.length + 1];
/* 129 */     System.arraycopy(XPROP_NET_WM_PID_ID, 0, arrayOfString, 0, XPROP_NET_WM_PID_ID.length);
/* 130 */     arrayOfString[XPROP_NET_WM_PID_ID.length] = paramString;
/* 131 */     List<String> list = ExecutingCommand.runNative(arrayOfString, null);
/* 132 */     if (list.isEmpty()) {
/* 133 */       return 0L;
/*     */     }
/* 135 */     return ParseUtil.getFirstIntValue(list.get(0));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\Xwininfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */