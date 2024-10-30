/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateFormatConverter
/*     */ {
/*  50 */   private static POILogger logger = POILogFactory.getLogger(DateFormatConverter.class);
/*     */   
/*     */   public static class DateFormatTokenizer {
/*     */     String format;
/*     */     int pos;
/*     */     
/*     */     public DateFormatTokenizer(String param1String) {
/*  57 */       this.format = param1String;
/*     */     }
/*     */     
/*     */     public String getNextToken() {
/*  61 */       if (this.pos >= this.format.length()) {
/*  62 */         return null;
/*     */       }
/*  64 */       int i = this.pos;
/*  65 */       char c = this.format.charAt(this.pos);
/*  66 */       this.pos++;
/*  67 */       if (c == '\'') {
/*  68 */         while (this.pos < this.format.length() && (c = this.format.charAt(this.pos)) != '\'') {
/*  69 */           this.pos++;
/*     */         }
/*  71 */         if (this.pos < this.format.length()) {
/*  72 */           this.pos++;
/*     */         }
/*     */       } else {
/*  75 */         char c1 = c;
/*  76 */         while (this.pos < this.format.length() && (c = this.format.charAt(this.pos)) == c1) {
/*  77 */           this.pos++;
/*     */         }
/*     */       } 
/*  80 */       return this.format.substring(i, this.pos);
/*     */     }
/*     */     
/*     */     public static String[] tokenize(String param1String) {
/*  84 */       ArrayList<String> arrayList = new ArrayList();
/*     */       
/*  86 */       DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(param1String);
/*     */       String str;
/*  88 */       while ((str = dateFormatTokenizer.getNextToken()) != null) {
/*  89 */         arrayList.add(str);
/*     */       }
/*     */       
/*  92 */       return arrayList.<String>toArray(new String[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  97 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*  99 */       DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(this.format);
/*     */       String str;
/* 101 */       while ((str = dateFormatTokenizer.getNextToken()) != null) {
/* 102 */         if (stringBuilder.length() > 0) {
/* 103 */           stringBuilder.append(", ");
/*     */         }
/* 105 */         stringBuilder.append("[").append(str).append("]");
/*     */       } 
/*     */       
/* 108 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/* 112 */   private static Map<String, String> tokenConversions = prepareTokenConversions();
/* 113 */   private static Map<String, String> localePrefixes = prepareLocalePrefixes();
/*     */   
/*     */   private static Map<String, String> prepareTokenConversions() {
/* 116 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 118 */     hashMap.put("EEEE", "dddd");
/* 119 */     hashMap.put("EEE", "ddd");
/* 120 */     hashMap.put("EE", "ddd");
/* 121 */     hashMap.put("E", "d");
/* 122 */     hashMap.put("Z", "");
/* 123 */     hashMap.put("z", "");
/* 124 */     hashMap.put("a", "am/pm");
/* 125 */     hashMap.put("A", "AM/PM");
/* 126 */     hashMap.put("K", "H");
/* 127 */     hashMap.put("KK", "HH");
/* 128 */     hashMap.put("k", "h");
/* 129 */     hashMap.put("kk", "hh");
/* 130 */     hashMap.put("S", "0");
/* 131 */     hashMap.put("SS", "00");
/* 132 */     hashMap.put("SSS", "000");
/*     */     
/* 134 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static Map<String, String> prepareLocalePrefixes() {
/* 138 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 140 */     hashMap.put("af", "[$-0436]");
/* 141 */     hashMap.put("am", "[$-45E]");
/* 142 */     hashMap.put("ar_ae", "[$-3801]");
/* 143 */     hashMap.put("ar_bh", "[$-3C01]");
/* 144 */     hashMap.put("ar_dz", "[$-1401]");
/* 145 */     hashMap.put("ar_eg", "[$-C01]");
/* 146 */     hashMap.put("ar_iq", "[$-0801]");
/* 147 */     hashMap.put("ar_jo", "[$-2C01]");
/* 148 */     hashMap.put("ar_kw", "[$-3401]");
/* 149 */     hashMap.put("ar_lb", "[$-3001]");
/* 150 */     hashMap.put("ar_ly", "[$-1001]");
/* 151 */     hashMap.put("ar_ma", "[$-1801]");
/* 152 */     hashMap.put("ar_om", "[$-2001]");
/* 153 */     hashMap.put("ar_qa", "[$-4001]");
/* 154 */     hashMap.put("ar_sa", "[$-0401]");
/* 155 */     hashMap.put("ar_sy", "[$-2801]");
/* 156 */     hashMap.put("ar_tn", "[$-1C01]");
/* 157 */     hashMap.put("ar_ye", "[$-2401]");
/* 158 */     hashMap.put("as", "[$-44D]");
/* 159 */     hashMap.put("az_az", "[$-82C]");
/* 160 */     hashMap.put("az_az", "[$-42C]");
/* 161 */     hashMap.put("be", "[$-0423]");
/* 162 */     hashMap.put("bg", "[$-0402]");
/* 163 */     hashMap.put("bn", "[$-0845]");
/* 164 */     hashMap.put("bn", "[$-0445]");
/* 165 */     hashMap.put("bo", "[$-0451]");
/* 166 */     hashMap.put("bs", "[$-141A]");
/* 167 */     hashMap.put("ca", "[$-0403]");
/* 168 */     hashMap.put("cs", "[$-0405]");
/* 169 */     hashMap.put("cy", "[$-0452]");
/* 170 */     hashMap.put("da", "[$-0406]");
/* 171 */     hashMap.put("de_at", "[$-C07]");
/* 172 */     hashMap.put("de_ch", "[$-0807]");
/* 173 */     hashMap.put("de_de", "[$-0407]");
/* 174 */     hashMap.put("de_li", "[$-1407]");
/* 175 */     hashMap.put("de_lu", "[$-1007]");
/* 176 */     hashMap.put("dv", "[$-0465]");
/* 177 */     hashMap.put("el", "[$-0408]");
/* 178 */     hashMap.put("en_au", "[$-C09]");
/* 179 */     hashMap.put("en_bz", "[$-2809]");
/* 180 */     hashMap.put("en_ca", "[$-1009]");
/* 181 */     hashMap.put("en_cb", "[$-2409]");
/* 182 */     hashMap.put("en_gb", "[$-0809]");
/* 183 */     hashMap.put("en_ie", "[$-1809]");
/* 184 */     hashMap.put("en_in", "[$-4009]");
/* 185 */     hashMap.put("en_jm", "[$-2009]");
/* 186 */     hashMap.put("en_nz", "[$-1409]");
/* 187 */     hashMap.put("en_ph", "[$-3409]");
/* 188 */     hashMap.put("en_tt", "[$-2C09]");
/* 189 */     hashMap.put("en_us", "[$-0409]");
/* 190 */     hashMap.put("en_za", "[$-1C09]");
/* 191 */     hashMap.put("es_ar", "[$-2C0A]");
/* 192 */     hashMap.put("es_bo", "[$-400A]");
/* 193 */     hashMap.put("es_cl", "[$-340A]");
/* 194 */     hashMap.put("es_co", "[$-240A]");
/* 195 */     hashMap.put("es_cr", "[$-140A]");
/* 196 */     hashMap.put("es_do", "[$-1C0A]");
/* 197 */     hashMap.put("es_ec", "[$-300A]");
/* 198 */     hashMap.put("es_es", "[$-40A]");
/* 199 */     hashMap.put("es_gt", "[$-100A]");
/* 200 */     hashMap.put("es_hn", "[$-480A]");
/* 201 */     hashMap.put("es_mx", "[$-80A]");
/* 202 */     hashMap.put("es_ni", "[$-4C0A]");
/* 203 */     hashMap.put("es_pa", "[$-180A]");
/* 204 */     hashMap.put("es_pe", "[$-280A]");
/* 205 */     hashMap.put("es_pr", "[$-500A]");
/* 206 */     hashMap.put("es_py", "[$-3C0A]");
/* 207 */     hashMap.put("es_sv", "[$-440A]");
/* 208 */     hashMap.put("es_uy", "[$-380A]");
/* 209 */     hashMap.put("es_ve", "[$-200A]");
/* 210 */     hashMap.put("et", "[$-0425]");
/* 211 */     hashMap.put("eu", "[$-42D]");
/* 212 */     hashMap.put("fa", "[$-0429]");
/* 213 */     hashMap.put("fi", "[$-40B]");
/* 214 */     hashMap.put("fo", "[$-0438]");
/* 215 */     hashMap.put("fr_be", "[$-80C]");
/* 216 */     hashMap.put("fr_ca", "[$-C0C]");
/* 217 */     hashMap.put("fr_ch", "[$-100C]");
/* 218 */     hashMap.put("fr_fr", "[$-40C]");
/* 219 */     hashMap.put("fr_lu", "[$-140C]");
/* 220 */     hashMap.put("gd", "[$-43C]");
/* 221 */     hashMap.put("gd_ie", "[$-83C]");
/* 222 */     hashMap.put("gn", "[$-0474]");
/* 223 */     hashMap.put("gu", "[$-0447]");
/* 224 */     hashMap.put("he", "[$-40D]");
/* 225 */     hashMap.put("hi", "[$-0439]");
/* 226 */     hashMap.put("hr", "[$-41A]");
/* 227 */     hashMap.put("hu", "[$-40E]");
/* 228 */     hashMap.put("hy", "[$-42B]");
/* 229 */     hashMap.put("id", "[$-0421]");
/* 230 */     hashMap.put("is", "[$-40F]");
/* 231 */     hashMap.put("it_ch", "[$-0810]");
/* 232 */     hashMap.put("it_it", "[$-0410]");
/* 233 */     hashMap.put("ja", "[$-0411]");
/* 234 */     hashMap.put("kk", "[$-43F]");
/* 235 */     hashMap.put("km", "[$-0453]");
/* 236 */     hashMap.put("kn", "[$-44B]");
/* 237 */     hashMap.put("ko", "[$-0412]");
/* 238 */     hashMap.put("ks", "[$-0460]");
/* 239 */     hashMap.put("la", "[$-0476]");
/* 240 */     hashMap.put("lo", "[$-0454]");
/* 241 */     hashMap.put("lt", "[$-0427]");
/* 242 */     hashMap.put("lv", "[$-0426]");
/* 243 */     hashMap.put("mi", "[$-0481]");
/* 244 */     hashMap.put("mk", "[$-42F]");
/* 245 */     hashMap.put("ml", "[$-44C]");
/* 246 */     hashMap.put("mn", "[$-0850]");
/* 247 */     hashMap.put("mn", "[$-0450]");
/* 248 */     hashMap.put("mr", "[$-44E]");
/* 249 */     hashMap.put("ms_bn", "[$-83E]");
/* 250 */     hashMap.put("ms_my", "[$-43E]");
/* 251 */     hashMap.put("mt", "[$-43A]");
/* 252 */     hashMap.put("my", "[$-0455]");
/* 253 */     hashMap.put("ne", "[$-0461]");
/* 254 */     hashMap.put("nl_be", "[$-0813]");
/* 255 */     hashMap.put("nl_nl", "[$-0413]");
/* 256 */     hashMap.put("no_no", "[$-0814]");
/* 257 */     hashMap.put("or", "[$-0448]");
/* 258 */     hashMap.put("pa", "[$-0446]");
/* 259 */     hashMap.put("pl", "[$-0415]");
/* 260 */     hashMap.put("pt_br", "[$-0416]");
/* 261 */     hashMap.put("pt_pt", "[$-0816]");
/* 262 */     hashMap.put("rm", "[$-0417]");
/* 263 */     hashMap.put("ro", "[$-0418]");
/* 264 */     hashMap.put("ro_mo", "[$-0818]");
/* 265 */     hashMap.put("ru", "[$-0419]");
/* 266 */     hashMap.put("ru_mo", "[$-0819]");
/* 267 */     hashMap.put("sa", "[$-44F]");
/* 268 */     hashMap.put("sb", "[$-42E]");
/* 269 */     hashMap.put("sd", "[$-0459]");
/* 270 */     hashMap.put("si", "[$-45B]");
/* 271 */     hashMap.put("sk", "[$-41B]");
/* 272 */     hashMap.put("sl", "[$-0424]");
/* 273 */     hashMap.put("so", "[$-0477]");
/* 274 */     hashMap.put("sq", "[$-41C]");
/* 275 */     hashMap.put("sr_sp", "[$-C1A]");
/* 276 */     hashMap.put("sr_sp", "[$-81A]");
/* 277 */     hashMap.put("sv_fi", "[$-81D]");
/* 278 */     hashMap.put("sv_se", "[$-41D]");
/* 279 */     hashMap.put("sw", "[$-0441]");
/* 280 */     hashMap.put("ta", "[$-0449]");
/* 281 */     hashMap.put("te", "[$-44A]");
/* 282 */     hashMap.put("tg", "[$-0428]");
/* 283 */     hashMap.put("th", "[$-41E]");
/* 284 */     hashMap.put("tk", "[$-0442]");
/* 285 */     hashMap.put("tn", "[$-0432]");
/* 286 */     hashMap.put("tr", "[$-41F]");
/* 287 */     hashMap.put("ts", "[$-0431]");
/* 288 */     hashMap.put("tt", "[$-0444]");
/* 289 */     hashMap.put("uk", "[$-0422]");
/* 290 */     hashMap.put("ur", "[$-0420]");
/* 291 */     hashMap.put("UTF_8", "[$-0000]");
/* 292 */     hashMap.put("uz_uz", "[$-0843]");
/* 293 */     hashMap.put("uz_uz", "[$-0443]");
/* 294 */     hashMap.put("vi", "[$-42A]");
/* 295 */     hashMap.put("xh", "[$-0434]");
/* 296 */     hashMap.put("yi", "[$-43D]");
/* 297 */     hashMap.put("zh_cn", "[$-0804]");
/* 298 */     hashMap.put("zh_hk", "[$-C04]");
/* 299 */     hashMap.put("zh_mo", "[$-1404]");
/* 300 */     hashMap.put("zh_sg", "[$-1004]");
/* 301 */     hashMap.put("zh_tw", "[$-0404]");
/* 302 */     hashMap.put("zu", "[$-0435]");
/*     */     
/* 304 */     hashMap.put("ar", "[$-0401]");
/* 305 */     hashMap.put("bn", "[$-0845]");
/* 306 */     hashMap.put("de", "[$-0407]");
/* 307 */     hashMap.put("en", "[$-0409]");
/* 308 */     hashMap.put("es", "[$-40A]");
/* 309 */     hashMap.put("fr", "[$-40C]");
/* 310 */     hashMap.put("it", "[$-0410]");
/* 311 */     hashMap.put("ms", "[$-43E]");
/* 312 */     hashMap.put("nl", "[$-0413]");
/* 313 */     hashMap.put("nn", "[$-0814]");
/* 314 */     hashMap.put("no", "[$-0414]");
/* 315 */     hashMap.put("pt", "[$-0816]");
/* 316 */     hashMap.put("sr", "[$-C1A]");
/* 317 */     hashMap.put("sv", "[$-41D]");
/* 318 */     hashMap.put("uz", "[$-0843]");
/* 319 */     hashMap.put("zh", "[$-0804]");
/*     */     
/* 321 */     hashMap.put("ga", "[$-43C]");
/* 322 */     hashMap.put("ga_ie", "[$-83C]");
/* 323 */     hashMap.put("in", "[$-0421]");
/* 324 */     hashMap.put("iw", "[$-40D]");
/*     */ 
/*     */     
/* 327 */     hashMap.put("", "[$-0409]");
/*     */     
/* 329 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public static String getPrefixForLocale(Locale paramLocale) {
/* 333 */     String str1 = paramLocale.toString().toLowerCase(paramLocale);
/* 334 */     String str2 = localePrefixes.get(str1);
/* 335 */     if (str2 == null) {
/* 336 */       str2 = localePrefixes.get(str1.substring(0, 2));
/* 337 */       if (str2 == null) {
/* 338 */         Locale locale = new Locale(str1.substring(0, 2));
/* 339 */         logger.log(7, new Object[] { "Unable to find prefix for " + paramLocale + "(" + paramLocale.getDisplayName(Locale.ROOT) + ") or " + str1.substring(0, 2) + "(" + locale.getDisplayName(Locale.ROOT) + ")" });
/*     */         
/* 341 */         return "";
/*     */       } 
/*     */     } 
/* 344 */     return str2;
/*     */   }
/*     */   
/*     */   public static String convert(Locale paramLocale, DateFormat paramDateFormat) {
/* 348 */     String str = ((SimpleDateFormat)paramDateFormat).toPattern();
/* 349 */     return convert(paramLocale, str);
/*     */   }
/*     */   
/*     */   public static String convert(Locale paramLocale, String paramString) {
/* 353 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 355 */     stringBuilder.append(getPrefixForLocale(paramLocale));
/* 356 */     DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(paramString);
/*     */     String str;
/* 358 */     while ((str = dateFormatTokenizer.getNextToken()) != null) {
/* 359 */       if (str.startsWith("'")) {
/* 360 */         stringBuilder.append(str.replaceAll("'", "\"")); continue;
/* 361 */       }  if (!Character.isLetter(str.charAt(0))) {
/* 362 */         stringBuilder.append(str);
/*     */         continue;
/*     */       } 
/* 365 */       String str1 = tokenConversions.get(str);
/* 366 */       stringBuilder.append((str1 == null) ? str : str1);
/*     */     } 
/*     */     
/* 369 */     stringBuilder.append(";@");
/* 370 */     return stringBuilder.toString().trim();
/*     */   }
/*     */   
/*     */   public static String getJavaDatePattern(int paramInt, Locale paramLocale) {
/* 374 */     DateFormat dateFormat = DateFormat.getDateInstance(paramInt, paramLocale);
/* 375 */     if (dateFormat instanceof SimpleDateFormat) {
/* 376 */       return ((SimpleDateFormat)dateFormat).toPattern();
/*     */     }
/* 378 */     switch (paramInt) {
/*     */       case 3:
/* 380 */         return "d/MM/yy";
/*     */       case 2:
/* 382 */         return "MMM d, yyyy";
/*     */       case 1:
/* 384 */         return "MMMM d, yyyy";
/*     */       case 0:
/* 386 */         return "dddd, MMMM d, yyyy";
/*     */     } 
/* 388 */     return "MMM d, yyyy";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getJavaTimePattern(int paramInt, Locale paramLocale) {
/* 394 */     DateFormat dateFormat = DateFormat.getTimeInstance(paramInt, paramLocale);
/* 395 */     if (dateFormat instanceof SimpleDateFormat) {
/* 396 */       return ((SimpleDateFormat)dateFormat).toPattern();
/*     */     }
/* 398 */     switch (paramInt) {
/*     */       case 3:
/* 400 */         return "h:mm a";
/*     */       case 2:
/* 402 */         return "h:mm:ss a";
/*     */       case 1:
/* 404 */         return "h:mm:ss a";
/*     */       case 0:
/* 406 */         return "h:mm:ss a";
/*     */     } 
/* 408 */     return "h:mm:ss a";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getJavaDateTimePattern(int paramInt, Locale paramLocale) {
/* 414 */     DateFormat dateFormat = DateFormat.getDateTimeInstance(paramInt, paramInt, paramLocale);
/* 415 */     if (dateFormat instanceof SimpleDateFormat) {
/* 416 */       return ((SimpleDateFormat)dateFormat).toPattern();
/*     */     }
/* 418 */     switch (paramInt) {
/*     */       case 3:
/* 420 */         return "M/d/yy h:mm a";
/*     */       case 2:
/* 422 */         return "MMM d, yyyy h:mm:ss a";
/*     */       case 1:
/* 424 */         return "MMMM d, yyyy h:mm:ss a";
/*     */       case 0:
/* 426 */         return "dddd, MMMM d, yyyy h:mm:ss a";
/*     */     } 
/* 428 */     return "MMM d, yyyy h:mm:ss a";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\DateFormatConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */