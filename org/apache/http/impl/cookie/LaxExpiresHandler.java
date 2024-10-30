/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.BitSet;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.cookie.SetCookie;
/*     */ import org.apache.http.message.ParserCursor;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.TextUtils;
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
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class LaxExpiresHandler
/*     */   extends AbstractCookieAttributeHandler
/*     */   implements CommonCookieAttributeHandler
/*     */ {
/*  55 */   static final TimeZone UTC = TimeZone.getTimeZone("UTC");
/*     */   private static final BitSet DELIMS;
/*     */   
/*     */   static {
/*  59 */     BitSet bitSet = new BitSet();
/*  60 */     bitSet.set(9); byte b;
/*  61 */     for (b = 32; b <= 47; b++) {
/*  62 */       bitSet.set(b);
/*     */     }
/*  64 */     for (b = 59; b <= 64; b++) {
/*  65 */       bitSet.set(b);
/*     */     }
/*  67 */     for (b = 91; b <= 96; b++) {
/*  68 */       bitSet.set(b);
/*     */     }
/*  70 */     for (b = 123; b <= 126; b++) {
/*  71 */       bitSet.set(b);
/*     */     }
/*  73 */     DELIMS = bitSet;
/*     */ 
/*     */ 
/*     */     
/*  77 */     ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>(12);
/*  78 */     concurrentHashMap.put("jan", Integer.valueOf(0));
/*  79 */     concurrentHashMap.put("feb", Integer.valueOf(1));
/*  80 */     concurrentHashMap.put("mar", Integer.valueOf(2));
/*  81 */     concurrentHashMap.put("apr", Integer.valueOf(3));
/*  82 */     concurrentHashMap.put("may", Integer.valueOf(4));
/*  83 */     concurrentHashMap.put("jun", Integer.valueOf(5));
/*  84 */     concurrentHashMap.put("jul", Integer.valueOf(6));
/*  85 */     concurrentHashMap.put("aug", Integer.valueOf(7));
/*  86 */     concurrentHashMap.put("sep", Integer.valueOf(8));
/*  87 */     concurrentHashMap.put("oct", Integer.valueOf(9));
/*  88 */     concurrentHashMap.put("nov", Integer.valueOf(10));
/*  89 */     concurrentHashMap.put("dec", Integer.valueOf(11));
/*  90 */     MONTHS = (Map)concurrentHashMap;
/*     */   }
/*     */   private static final Map<String, Integer> MONTHS;
/*  93 */   private static final Pattern TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
/*     */   
/*  95 */   private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
/*     */   
/*  97 */   private static final Pattern MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
/*     */   
/*  99 */   private static final Pattern YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 108 */     Args.notNull(paramSetCookie, "Cookie");
/* 109 */     if (TextUtils.isBlank(paramString)) {
/*     */       return;
/*     */     }
/* 112 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 113 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 115 */     int i = 0, j = 0, k = 0, m = 0, n = 0, i1 = 0;
/* 116 */     boolean bool1 = false, bool2 = false, bool3 = false, bool4 = false;
/*     */     try {
/* 118 */       while (!parserCursor.atEnd()) {
/* 119 */         skipDelims(paramString, parserCursor);
/* 120 */         stringBuilder.setLength(0);
/* 121 */         copyContent(paramString, parserCursor, stringBuilder);
/*     */         
/* 123 */         if (stringBuilder.length() == 0) {
/*     */           break;
/*     */         }
/* 126 */         if (!bool1) {
/* 127 */           Matcher matcher = TIME_PATTERN.matcher(stringBuilder);
/* 128 */           if (matcher.matches()) {
/* 129 */             bool1 = true;
/* 130 */             k = Integer.parseInt(matcher.group(1));
/* 131 */             j = Integer.parseInt(matcher.group(2));
/* 132 */             i = Integer.parseInt(matcher.group(3));
/*     */             continue;
/*     */           } 
/*     */         } 
/* 136 */         if (!bool2) {
/* 137 */           Matcher matcher = DAY_OF_MONTH_PATTERN.matcher(stringBuilder);
/* 138 */           if (matcher.matches()) {
/* 139 */             bool2 = true;
/* 140 */             m = Integer.parseInt(matcher.group(1));
/*     */             continue;
/*     */           } 
/*     */         } 
/* 144 */         if (!bool3) {
/* 145 */           Matcher matcher = MONTH_PATTERN.matcher(stringBuilder);
/* 146 */           if (matcher.matches()) {
/* 147 */             bool3 = true;
/* 148 */             n = ((Integer)MONTHS.get(matcher.group(1).toLowerCase(Locale.ROOT))).intValue();
/*     */             continue;
/*     */           } 
/*     */         } 
/* 152 */         if (!bool4) {
/* 153 */           Matcher matcher = YEAR_PATTERN.matcher(stringBuilder);
/* 154 */           if (matcher.matches()) {
/* 155 */             bool4 = true;
/* 156 */             i1 = Integer.parseInt(matcher.group(1));
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/* 161 */     } catch (NumberFormatException numberFormatException) {
/* 162 */       throw new MalformedCookieException("Invalid 'expires' attribute: " + paramString);
/*     */     } 
/* 164 */     if (!bool1 || !bool2 || !bool3 || !bool4) {
/* 165 */       throw new MalformedCookieException("Invalid 'expires' attribute: " + paramString);
/*     */     }
/* 167 */     if (i1 >= 70 && i1 <= 99) {
/* 168 */       i1 = 1900 + i1;
/*     */     }
/* 170 */     if (i1 >= 0 && i1 <= 69) {
/* 171 */       i1 = 2000 + i1;
/*     */     }
/* 173 */     if (m < 1 || m > 31 || i1 < 1601 || k > 23 || j > 59 || i > 59) {
/* 174 */       throw new MalformedCookieException("Invalid 'expires' attribute: " + paramString);
/*     */     }
/*     */     
/* 177 */     Calendar calendar = Calendar.getInstance();
/* 178 */     calendar.setTimeZone(UTC);
/* 179 */     calendar.setTimeInMillis(0L);
/* 180 */     calendar.set(13, i);
/* 181 */     calendar.set(12, j);
/* 182 */     calendar.set(11, k);
/* 183 */     calendar.set(5, m);
/* 184 */     calendar.set(2, n);
/* 185 */     calendar.set(1, i1);
/* 186 */     paramSetCookie.setExpiryDate(calendar.getTime());
/*     */   }
/*     */   
/*     */   private void skipDelims(CharSequence paramCharSequence, ParserCursor paramParserCursor) {
/* 190 */     int i = paramParserCursor.getPos();
/* 191 */     int j = paramParserCursor.getPos();
/* 192 */     int k = paramParserCursor.getUpperBound();
/* 193 */     for (int m = j; m < k; ) {
/* 194 */       char c = paramCharSequence.charAt(m);
/* 195 */       if (DELIMS.get(c)) {
/* 196 */         i++;
/*     */         
/*     */         m++;
/*     */       } 
/*     */     } 
/* 201 */     paramParserCursor.updatePos(i);
/*     */   }
/*     */   
/*     */   private void copyContent(CharSequence paramCharSequence, ParserCursor paramParserCursor, StringBuilder paramStringBuilder) {
/* 205 */     int i = paramParserCursor.getPos();
/* 206 */     int j = paramParserCursor.getPos();
/* 207 */     int k = paramParserCursor.getUpperBound();
/* 208 */     for (int m = j; m < k; m++) {
/* 209 */       char c = paramCharSequence.charAt(m);
/* 210 */       if (DELIMS.get(c)) {
/*     */         break;
/*     */       }
/* 213 */       i++;
/* 214 */       paramStringBuilder.append(c);
/*     */     } 
/* 216 */     paramParserCursor.updatePos(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttributeName() {
/* 221 */     return "expires";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\LaxExpiresHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */