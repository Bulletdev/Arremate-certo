/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public class EncodingMap
/*     */ {
/*     */   public static String getJava2IANAMapping(String paramString) {
/*  26 */     String str = (String)_java_to_iana.get(paramString.toUpperCase());
/*  27 */     if (str != null) {
/*  28 */       return str;
/*     */     }
/*  30 */     if (Charset.isSupported(paramString)) {
/*     */       
/*     */       try {
/*     */         
/*  34 */         str = Charset.forName(paramString).name();
/*  35 */         return str;
/*     */       }
/*  37 */       catch (IllegalArgumentException illegalArgumentException) {
/*     */         
/*  39 */         return null;
/*     */       } 
/*     */     }
/*  42 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getIANA2JavaMapping(String paramString) {
/*  47 */     String str = (String)_iana_to_java.get(paramString.toUpperCase());
/*  48 */     if (str != null)
/*  49 */       return str; 
/*  50 */     if (Charset.isSupported(paramString)) {
/*  51 */       return paramString;
/*     */     }
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static final HashMap _iana_to_java = new HashMap();
/*  59 */   private static final HashMap _java_to_iana = new HashMap();
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static final void addMapping(String paramString1, String paramString2, boolean paramBoolean) {
/*  64 */     assert !_iana_to_java.containsKey(paramString2);
/*  65 */     assert paramString1.toUpperCase().equals(paramString1);
/*  66 */     assert paramString2.toUpperCase().equals(paramString2);
/*     */     
/*  68 */     _iana_to_java.put(paramString2, paramString1);
/*     */     
/*  70 */     if (paramBoolean) {
/*     */       
/*  72 */       assert !_java_to_iana.containsKey(paramString1);
/*  73 */       _java_to_iana.put(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static final boolean completeMappings() {
/*  79 */     HashMap hashMap = new HashMap();
/*     */     
/*  81 */     for (null = _iana_to_java.keySet().iterator(); null.hasNext();) {
/*  82 */       hashMap.put(_iana_to_java.get(null.next()), null);
/*     */     }
/*  84 */     for (Object object : hashMap.keySet())
/*     */     {
/*     */       
/*  87 */       assert _java_to_iana.containsKey(object) : object;
/*     */     }
/*     */     
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*  95 */     addMapping("ASCII", "ANSI_X3.4-1986", false);
/*  96 */     addMapping("ASCII", "ASCII", true);
/*  97 */     addMapping("ASCII", "CP367", false);
/*  98 */     addMapping("ASCII", "CSASCII", false);
/*  99 */     addMapping("ASCII", "IBM-367", false);
/* 100 */     addMapping("ASCII", "IBM367", false);
/* 101 */     addMapping("ASCII", "ISO-IR-6", false);
/* 102 */     addMapping("ASCII", "ISO646-US", false);
/* 103 */     addMapping("ASCII", "ISO_646.IRV:1991", false);
/* 104 */     addMapping("ASCII", "US", false);
/* 105 */     addMapping("ASCII", "US-ASCII", false);
/* 106 */     addMapping("BIG5", "BIG5", true);
/* 107 */     addMapping("BIG5", "CSBIG5", false);
/* 108 */     addMapping("CP037", "CP037", false);
/* 109 */     addMapping("CP037", "CSIBM037", false);
/* 110 */     addMapping("CP037", "EBCDIC-CP-CA", false);
/* 111 */     addMapping("CP037", "EBCDIC-CP-NL", false);
/* 112 */     addMapping("CP037", "EBCDIC-CP-US", true);
/* 113 */     addMapping("CP037", "EBCDIC-CP-WT", false);
/* 114 */     addMapping("CP037", "IBM-37", false);
/* 115 */     addMapping("CP037", "IBM037", false);
/* 116 */     addMapping("CP1026", "CP1026", false);
/* 117 */     addMapping("CP1026", "CSIBM1026", false);
/* 118 */     addMapping("CP1026", "IBM-1026", false);
/* 119 */     addMapping("CP1026", "IBM1026", true);
/* 120 */     addMapping("CP1047", "CP1047", false);
/* 121 */     addMapping("CP1047", "IBM-1047", false);
/* 122 */     addMapping("CP1047", "IBM1047", true);
/* 123 */     addMapping("CP1140", "CCSID01140", false);
/* 124 */     addMapping("CP1140", "CP01140", false);
/* 125 */     addMapping("CP1140", "IBM-1140", false);
/* 126 */     addMapping("CP1140", "IBM01140", true);
/* 127 */     addMapping("CP1141", "CCSID01141", false);
/* 128 */     addMapping("CP1141", "CP01141", false);
/* 129 */     addMapping("CP1141", "IBM-1141", false);
/* 130 */     addMapping("CP1141", "IBM01141", true);
/* 131 */     addMapping("CP1142", "CCSID01142", false);
/* 132 */     addMapping("CP1142", "CP01142", false);
/* 133 */     addMapping("CP1142", "IBM-1142", false);
/* 134 */     addMapping("CP1142", "IBM01142", true);
/* 135 */     addMapping("CP1143", "CCSID01143", false);
/* 136 */     addMapping("CP1143", "CP01143", false);
/* 137 */     addMapping("CP1143", "IBM-1143", false);
/* 138 */     addMapping("CP1143", "IBM01143", true);
/* 139 */     addMapping("CP1144", "CCSID01144", false);
/* 140 */     addMapping("CP1144", "CP01144", false);
/* 141 */     addMapping("CP1144", "IBM-1144", false);
/* 142 */     addMapping("CP1144", "IBM01144", true);
/* 143 */     addMapping("CP1145", "CCSID01145", false);
/* 144 */     addMapping("CP1145", "CP01145", false);
/* 145 */     addMapping("CP1145", "IBM-1145", false);
/* 146 */     addMapping("CP1145", "IBM01145", true);
/* 147 */     addMapping("CP1146", "CCSID01146", false);
/* 148 */     addMapping("CP1146", "CP01146", false);
/* 149 */     addMapping("CP1146", "IBM-1146", false);
/* 150 */     addMapping("CP1146", "IBM01146", true);
/* 151 */     addMapping("CP1147", "CCSID01147", false);
/* 152 */     addMapping("CP1147", "CP01147", false);
/* 153 */     addMapping("CP1147", "IBM-1147", false);
/* 154 */     addMapping("CP1147", "IBM01147", true);
/* 155 */     addMapping("CP1148", "CCSID01148", false);
/* 156 */     addMapping("CP1148", "CP01148", false);
/* 157 */     addMapping("CP1148", "IBM-1148", false);
/* 158 */     addMapping("CP1148", "IBM01148", true);
/* 159 */     addMapping("CP1149", "CCSID01149", false);
/* 160 */     addMapping("CP1149", "CP01149", false);
/* 161 */     addMapping("CP1149", "IBM-1149", false);
/* 162 */     addMapping("CP1149", "IBM01149", true);
/* 163 */     addMapping("CP1250", "WINDOWS-1250", true);
/* 164 */     addMapping("CP1251", "WINDOWS-1251", true);
/* 165 */     addMapping("CP1252", "WINDOWS-1252", true);
/* 166 */     addMapping("CP1253", "WINDOWS-1253", true);
/* 167 */     addMapping("CP1254", "WINDOWS-1254", true);
/* 168 */     addMapping("CP1255", "WINDOWS-1255", true);
/* 169 */     addMapping("CP1256", "WINDOWS-1256", true);
/* 170 */     addMapping("CP1257", "WINDOWS-1257", true);
/* 171 */     addMapping("CP1258", "WINDOWS-1258", true);
/* 172 */     addMapping("CP273", "CP273", false);
/* 173 */     addMapping("CP273", "CSIBM273", false);
/* 174 */     addMapping("CP273", "IBM-273", false);
/* 175 */     addMapping("CP273", "IBM273", true);
/* 176 */     addMapping("CP277", "CP277", false);
/* 177 */     addMapping("CP277", "CSIBM277", false);
/* 178 */     addMapping("CP277", "EBCDIC-CP-DK", true);
/* 179 */     addMapping("CP277", "EBCDIC-CP-NO", false);
/* 180 */     addMapping("CP277", "IBM-277", false);
/* 181 */     addMapping("CP277", "IBM277", false);
/* 182 */     addMapping("CP278", "CP278", false);
/* 183 */     addMapping("CP278", "CSIBM278", false);
/* 184 */     addMapping("CP278", "EBCDIC-CP-FI", true);
/* 185 */     addMapping("CP278", "EBCDIC-CP-SE", false);
/* 186 */     addMapping("CP278", "IBM-278", false);
/* 187 */     addMapping("CP278", "IBM278", false);
/* 188 */     addMapping("CP280", "CP280", false);
/* 189 */     addMapping("CP280", "CSIBM280", false);
/* 190 */     addMapping("CP280", "EBCDIC-CP-IT", true);
/* 191 */     addMapping("CP280", "IBM-280", false);
/* 192 */     addMapping("CP280", "IBM280", false);
/* 193 */     addMapping("CP284", "CP284", false);
/* 194 */     addMapping("CP284", "CSIBM284", false);
/* 195 */     addMapping("CP284", "EBCDIC-CP-ES", true);
/* 196 */     addMapping("CP284", "IBM-284", false);
/* 197 */     addMapping("CP284", "IBM284", false);
/* 198 */     addMapping("CP285", "CP285", false);
/* 199 */     addMapping("CP285", "CSIBM285", false);
/* 200 */     addMapping("CP285", "EBCDIC-CP-GB", true);
/* 201 */     addMapping("CP285", "IBM-285", false);
/* 202 */     addMapping("CP285", "IBM285", false);
/* 203 */     addMapping("CP290", "CP290", false);
/* 204 */     addMapping("CP290", "CSIBM290", false);
/* 205 */     addMapping("CP290", "EBCDIC-JP-KANA", true);
/* 206 */     addMapping("CP290", "IBM-290", false);
/* 207 */     addMapping("CP290", "IBM290", false);
/* 208 */     addMapping("CP297", "CP297", false);
/* 209 */     addMapping("CP297", "CSIBM297", false);
/* 210 */     addMapping("CP297", "EBCDIC-CP-FR", true);
/* 211 */     addMapping("CP297", "IBM-297", false);
/* 212 */     addMapping("CP297", "IBM297", false);
/* 213 */     addMapping("CP420", "CP420", false);
/* 214 */     addMapping("CP420", "CSIBM420", false);
/* 215 */     addMapping("CP420", "EBCDIC-CP-AR1", true);
/* 216 */     addMapping("CP420", "IBM-420", false);
/* 217 */     addMapping("CP420", "IBM420", false);
/* 218 */     addMapping("CP424", "CP424", false);
/* 219 */     addMapping("CP424", "CSIBM424", false);
/* 220 */     addMapping("CP424", "EBCDIC-CP-HE", true);
/* 221 */     addMapping("CP424", "IBM-424", false);
/* 222 */     addMapping("CP424", "IBM424", false);
/* 223 */     addMapping("CP437", "437", false);
/* 224 */     addMapping("CP437", "CP437", false);
/* 225 */     addMapping("CP437", "CSPC8CODEPAGE437", false);
/* 226 */     addMapping("CP437", "IBM-437", false);
/* 227 */     addMapping("CP437", "IBM437", true);
/* 228 */     addMapping("CP500", "CP500", false);
/* 229 */     addMapping("CP500", "CSIBM500", false);
/* 230 */     addMapping("CP500", "EBCDIC-CP-BE", false);
/* 231 */     addMapping("CP500", "EBCDIC-CP-CH", true);
/* 232 */     addMapping("CP500", "IBM-500", false);
/* 233 */     addMapping("CP500", "IBM500", false);
/* 234 */     addMapping("CP775", "CP775", false);
/* 235 */     addMapping("CP775", "CSPC775BALTIC", false);
/* 236 */     addMapping("CP775", "IBM-775", false);
/* 237 */     addMapping("CP775", "IBM775", true);
/* 238 */     addMapping("CP850", "850", false);
/* 239 */     addMapping("CP850", "CP850", false);
/* 240 */     addMapping("CP850", "CSPC850MULTILINGUAL", false);
/* 241 */     addMapping("CP850", "IBM-850", false);
/* 242 */     addMapping("CP850", "IBM850", true);
/* 243 */     addMapping("CP852", "852", false);
/* 244 */     addMapping("CP852", "CP852", false);
/* 245 */     addMapping("CP852", "CSPCP852", false);
/* 246 */     addMapping("CP852", "IBM-852", false);
/* 247 */     addMapping("CP852", "IBM852", true);
/* 248 */     addMapping("CP855", "855", false);
/* 249 */     addMapping("CP855", "CP855", false);
/* 250 */     addMapping("CP855", "CSIBM855", false);
/* 251 */     addMapping("CP855", "IBM-855", false);
/* 252 */     addMapping("CP855", "IBM855", true);
/* 253 */     addMapping("CP857", "857", false);
/* 254 */     addMapping("CP857", "CP857", false);
/* 255 */     addMapping("CP857", "CSIBM857", false);
/* 256 */     addMapping("CP857", "IBM-857", false);
/* 257 */     addMapping("CP857", "IBM857", true);
/* 258 */     addMapping("CP858", "CCSID00858", false);
/* 259 */     addMapping("CP858", "CP00858", false);
/* 260 */     addMapping("CP858", "IBM-858", false);
/* 261 */     addMapping("CP858", "IBM00858", true);
/* 262 */     addMapping("CP860", "860", false);
/* 263 */     addMapping("CP860", "CP860", false);
/* 264 */     addMapping("CP860", "CSIBM860", false);
/* 265 */     addMapping("CP860", "IBM-860", false);
/* 266 */     addMapping("CP860", "IBM860", true);
/* 267 */     addMapping("CP861", "861", false);
/* 268 */     addMapping("CP861", "CP-IS", false);
/* 269 */     addMapping("CP861", "CP861", false);
/* 270 */     addMapping("CP861", "CSIBM861", false);
/* 271 */     addMapping("CP861", "IBM-861", false);
/* 272 */     addMapping("CP861", "IBM861", true);
/* 273 */     addMapping("CP862", "862", false);
/* 274 */     addMapping("CP862", "CP862", false);
/* 275 */     addMapping("CP862", "CSPC862LATINHEBREW", false);
/* 276 */     addMapping("CP862", "IBM-862", false);
/* 277 */     addMapping("CP862", "IBM862", true);
/* 278 */     addMapping("CP863", "863", false);
/* 279 */     addMapping("CP863", "CP863", false);
/* 280 */     addMapping("CP863", "CSIBM863", false);
/* 281 */     addMapping("CP863", "IBM-863", false);
/* 282 */     addMapping("CP863", "IBM863", true);
/* 283 */     addMapping("CP864", "CP864", false);
/* 284 */     addMapping("CP864", "CSIBM864", false);
/* 285 */     addMapping("CP864", "IBM-864", false);
/* 286 */     addMapping("CP864", "IBM864", true);
/* 287 */     addMapping("CP865", "865", false);
/* 288 */     addMapping("CP865", "CP865", false);
/* 289 */     addMapping("CP865", "CSIBM865", false);
/* 290 */     addMapping("CP865", "IBM-865", false);
/* 291 */     addMapping("CP865", "IBM865", true);
/* 292 */     addMapping("CP866", "866", false);
/* 293 */     addMapping("CP866", "CP866", false);
/* 294 */     addMapping("CP866", "CSIBM866", false);
/* 295 */     addMapping("CP866", "IBM-866", false);
/* 296 */     addMapping("CP866", "IBM866", true);
/* 297 */     addMapping("CP868", "CP-AR", false);
/* 298 */     addMapping("CP868", "CP868", false);
/* 299 */     addMapping("CP868", "CSIBM868", false);
/* 300 */     addMapping("CP868", "IBM-868", false);
/* 301 */     addMapping("CP868", "IBM868", true);
/* 302 */     addMapping("CP869", "CP-GR", false);
/* 303 */     addMapping("CP869", "CP869", false);
/* 304 */     addMapping("CP869", "CSIBM869", false);
/* 305 */     addMapping("CP869", "IBM-869", false);
/* 306 */     addMapping("CP869", "IBM869", true);
/* 307 */     addMapping("CP870", "CP870", false);
/* 308 */     addMapping("CP870", "CSIBM870", false);
/* 309 */     addMapping("CP870", "EBCDIC-CP-ROECE", true);
/* 310 */     addMapping("CP870", "EBCDIC-CP-YU", false);
/* 311 */     addMapping("CP870", "IBM-870", false);
/* 312 */     addMapping("CP870", "IBM870", false);
/* 313 */     addMapping("CP871", "CP871", false);
/* 314 */     addMapping("CP871", "CSIBM871", false);
/* 315 */     addMapping("CP871", "EBCDIC-CP-IS", true);
/* 316 */     addMapping("CP871", "IBM-871", false);
/* 317 */     addMapping("CP871", "IBM871", false);
/* 318 */     addMapping("CP918", "CP918", false);
/* 319 */     addMapping("CP918", "CSIBM918", false);
/* 320 */     addMapping("CP918", "EBCDIC-CP-AR2", true);
/* 321 */     addMapping("CP918", "IBM-918", false);
/* 322 */     addMapping("CP918", "IBM918", false);
/* 323 */     addMapping("CP924", "CCSID00924", false);
/* 324 */     addMapping("CP924", "CP00924", false);
/* 325 */     addMapping("CP924", "EBCDIC-LATIN9--EURO", false);
/* 326 */     addMapping("CP924", "IBM-924", false);
/* 327 */     addMapping("CP924", "IBM00924", true);
/* 328 */     addMapping("CP936", "GBK", true);
/* 329 */     addMapping("CP936", "CP936", false);
/* 330 */     addMapping("CP936", "MS936", false);
/* 331 */     addMapping("CP936", "WINDOWS-936", false);
/* 332 */     addMapping("EUCJIS", "CSEUCPKDFMTJAPANESE", false);
/* 333 */     addMapping("EUCJIS", "EUC-JP", true);
/* 334 */     addMapping("EUCJIS", "EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE", false);
/* 335 */     addMapping("GB18030", "GB18030", true);
/* 336 */     addMapping("GB2312", "CSGB2312", false);
/* 337 */     addMapping("GB2312", "GB2312", true);
/* 338 */     addMapping("ISO2022CN", "ISO-2022-CN", true);
/* 339 */     addMapping("ISO2022KR", "CSISO2022KR", false);
/* 340 */     addMapping("ISO2022KR", "ISO-2022-KR", true);
/* 341 */     addMapping("ISO8859_1", "CP819", false);
/* 342 */     addMapping("ISO8859_1", "CSISOLATIN1", false);
/* 343 */     addMapping("ISO8859_1", "IBM-819", false);
/* 344 */     addMapping("ISO8859_1", "IBM819", false);
/* 345 */     addMapping("ISO8859_1", "ISO-8859-1", true);
/* 346 */     addMapping("ISO8859_1", "ISO-IR-100", false);
/* 347 */     addMapping("ISO8859_1", "ISO_8859-1", false);
/* 348 */     addMapping("ISO8859_1", "L1", false);
/* 349 */     addMapping("ISO8859_1", "LATIN1", false);
/* 350 */     addMapping("ISO8859_2", "CSISOLATIN2", false);
/* 351 */     addMapping("ISO8859_2", "ISO-8859-2", true);
/* 352 */     addMapping("ISO8859_2", "ISO-IR-101", false);
/* 353 */     addMapping("ISO8859_2", "ISO_8859-2", false);
/* 354 */     addMapping("ISO8859_2", "L2", false);
/* 355 */     addMapping("ISO8859_2", "LATIN2", false);
/* 356 */     addMapping("ISO8859_3", "CSISOLATIN3", false);
/* 357 */     addMapping("ISO8859_3", "ISO-8859-3", true);
/* 358 */     addMapping("ISO8859_3", "ISO-IR-109", false);
/* 359 */     addMapping("ISO8859_3", "ISO_8859-3", false);
/* 360 */     addMapping("ISO8859_3", "L3", false);
/* 361 */     addMapping("ISO8859_3", "LATIN3", false);
/* 362 */     addMapping("ISO8859_4", "CSISOLATIN4", false);
/* 363 */     addMapping("ISO8859_4", "ISO-8859-4", true);
/* 364 */     addMapping("ISO8859_4", "ISO-IR-110", false);
/* 365 */     addMapping("ISO8859_4", "ISO_8859-4", false);
/* 366 */     addMapping("ISO8859_4", "L4", false);
/* 367 */     addMapping("ISO8859_4", "LATIN4", false);
/* 368 */     addMapping("ISO8859_5", "CSISOLATINCYRILLIC", false);
/* 369 */     addMapping("ISO8859_5", "CYRILLIC", false);
/* 370 */     addMapping("ISO8859_5", "ISO-8859-5", true);
/* 371 */     addMapping("ISO8859_5", "ISO-IR-144", false);
/* 372 */     addMapping("ISO8859_5", "ISO_8859-5", false);
/* 373 */     addMapping("ISO8859_6", "ARABIC", false);
/* 374 */     addMapping("ISO8859_6", "ASMO-708", false);
/* 375 */     addMapping("ISO8859_6", "CSISOLATINARABIC", false);
/* 376 */     addMapping("ISO8859_6", "ECMA-114", false);
/* 377 */     addMapping("ISO8859_6", "ISO-8859-6", true);
/* 378 */     addMapping("ISO8859_6", "ISO-IR-127", false);
/* 379 */     addMapping("ISO8859_6", "ISO_8859-6", false);
/* 380 */     addMapping("ISO8859_7", "CSISOLATINGREEK", false);
/* 381 */     addMapping("ISO8859_7", "ECMA-118", false);
/* 382 */     addMapping("ISO8859_7", "ELOT_928", false);
/* 383 */     addMapping("ISO8859_7", "GREEK", false);
/* 384 */     addMapping("ISO8859_7", "GREEK8", false);
/* 385 */     addMapping("ISO8859_7", "ISO-8859-7", true);
/* 386 */     addMapping("ISO8859_7", "ISO-IR-126", false);
/* 387 */     addMapping("ISO8859_7", "ISO_8859-7", false);
/* 388 */     addMapping("ISO8859_8", "CSISOLATINHEBREW", false);
/* 389 */     addMapping("ISO8859_8", "HEBREW", false);
/* 390 */     addMapping("ISO8859_8", "ISO-8859-8", true);
/* 391 */     addMapping("ISO8859_8", "ISO-8859-8-I", false);
/* 392 */     addMapping("ISO8859_8", "ISO-IR-138", false);
/* 393 */     addMapping("ISO8859_8", "ISO_8859-8", false);
/* 394 */     addMapping("ISO8859_9", "CSISOLATIN5", false);
/* 395 */     addMapping("ISO8859_9", "ISO-8859-9", true);
/* 396 */     addMapping("ISO8859_9", "ISO-IR-148", false);
/* 397 */     addMapping("ISO8859_9", "ISO_8859-9", false);
/* 398 */     addMapping("ISO8859_9", "L5", false);
/* 399 */     addMapping("ISO8859_9", "LATIN5", false);
/* 400 */     addMapping("JIS", "CSISO2022JP", false);
/* 401 */     addMapping("JIS", "ISO-2022-JP", true);
/* 402 */     addMapping("JIS0201", "CSISO13JISC6220JP", false);
/* 403 */     addMapping("JIS0201", "X0201", true);
/* 404 */     addMapping("JIS0208", "CSISO87JISX0208", false);
/* 405 */     addMapping("JIS0208", "ISO-IR-87", false);
/* 406 */     addMapping("JIS0208", "X0208", true);
/* 407 */     addMapping("JIS0208", "X0208DBIJIS_X0208-1983", false);
/* 408 */     addMapping("JIS0212", "CSISO159JISX02121990", false);
/* 409 */     addMapping("JIS0212", "ISO-IR-159", true);
/* 410 */     addMapping("JIS0212", "X0212", false);
/* 411 */     addMapping("KOI8_R", "CSKOI8R", false);
/* 412 */     addMapping("KOI8_R", "KOI8-R", true);
/* 413 */     addMapping("KSC5601", "EUC-KR", true);
/* 414 */     addMapping("MS932", "CSWINDOWS31J", false);
/* 415 */     addMapping("MS932", "WINDOWS-31J", true);
/* 416 */     addMapping("SJIS", "CSSHIFTJIS", false);
/* 417 */     addMapping("SJIS", "MS_KANJI", false);
/* 418 */     addMapping("SJIS", "SHIFT_JIS", true);
/* 419 */     addMapping("TIS620", "TIS-620", true);
/* 420 */     addMapping("UNICODE", "UTF-16", true);
/* 421 */     addMapping("UTF-16BE", "UTF-16BE", true);
/* 422 */     addMapping("UTF-16BE", "UTF_16BE", false);
/* 423 */     addMapping("ISO-10646-UCS-2", "ISO-10646-UCS-2", true);
/* 424 */     addMapping("UTF-16LE", "UTF-16LE", true);
/* 425 */     addMapping("UTF-16LE", "UTF_16LE", false);
/* 426 */     addMapping("UTF8", "UTF-8", true);
/*     */     
/* 428 */     assert completeMappings();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\EncodingMap.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */