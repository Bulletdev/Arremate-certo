/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
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
/*     */ public final class XMLStreamReader
/*     */   extends XMLInputReader
/*     */ {
/*     */   private static final int BYTE_BUFFER_SIZE = 8192;
/*     */   private XMLDecoder decoder;
/*     */   private int minBytesPerChar;
/*     */   private int maxBytesPerChar;
/*     */   private InputStream in;
/*  40 */   private int[] decodeResult = new int[2];
/*     */   private String encoding;
/*     */   private boolean useDeclaredEncoding;
/*     */   private boolean rewindDeclaration;
/*  44 */   private char[] cbuf = new char[100];
/*  45 */   private byte[] bbuf = new byte[8192]; private int cbufPos;
/*     */   private int cbufEnd;
/*     */   private int bbufPos;
/*     */   private int bbufEnd;
/*     */   private boolean eofReached;
/*     */   private static final int MAX_XML_DECL_CHARS = 100;
/*  51 */   private FastStreamDecoder fastStreamDecoder = new FastStreamDecoder();
/*  52 */   private JavaStreamDecoder javaStreamDecoder = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XMLStreamDecoder activeStreamDecoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLStreamReader(InputStream paramInputStream, boolean paramBoolean) throws IOException {
/*  72 */     this(paramInputStream, (String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLStreamReader(InputStream paramInputStream, String paramString, boolean paramBoolean) throws IOException {
/*  81 */     reset(paramInputStream, paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset(InputStream paramInputStream, String paramString, boolean paramBoolean) throws IOException {
/*  89 */     resetInput();
/*  90 */     this.in = paramInputStream;
/*  91 */     this.eofReached = false;
/*  92 */     this.rewindDeclaration = paramBoolean;
/*  93 */     this.useDeclaredEncoding = false;
/*  94 */     this.bbufPos = this.bbufEnd = 0;
/*  95 */     this.cbufPos = this.cbufEnd = 0;
/*  96 */     this.activeStreamDecoder = this.fastStreamDecoder;
/*  97 */     fillByteBuffer(true);
/*     */     
/*  99 */     if (paramString != null) {
/* 100 */       this.encoding = getJavaCharset(paramString);
/*     */ 
/*     */ 
/*     */       
/* 104 */       if (this.encoding.equals("Unicode")) {
/* 105 */         this.encoding = guessEncoding();
/* 106 */         if (this.encoding == null || !this.encoding.equals("UnicodeLittle"))
/*     */         {
/* 108 */           this.encoding = "UnicodeBig";
/*     */         }
/*     */       } 
/*     */     } else {
/* 112 */       this.encoding = guessEncoding();
/* 113 */       if (this.encoding == null) {
/* 114 */         this.useDeclaredEncoding = true;
/* 115 */         this.encoding = "UTF-8";
/*     */       } 
/*     */     } 
/* 118 */     setEncoding(this.encoding);
/* 119 */     processXMLDecl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/* 127 */     return this.encoding;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 132 */     this.eofReached = true;
/* 133 */     this.bbufPos = this.bbufEnd = this.cbufPos = this.cbufEnd = 0;
/* 134 */     if (this.in != null)
/* 135 */       this.in.close(); 
/*     */   }
/*     */   
/*     */   public void reset() throws IOException {
/* 139 */     resetInput();
/* 140 */     this.in.reset();
/* 141 */     this.bbufPos = this.bbufEnd = this.cbufPos = this.cbufEnd = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) throws IOException {
/* 146 */     throw new UnsupportedOperationException("mark() not supported");
/*     */   }
/*     */   
/*     */   public boolean markSupported() {
/* 150 */     return false;
/*     */   }
/*     */   
/*     */   public int read() throws IOException {
/* 154 */     return this.activeStreamDecoder.read();
/*     */   }
/*     */   
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/* 158 */     return read(paramArrayOfchar, 0, paramArrayOfchar.length);
/*     */   }
/*     */   
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 162 */     return this.activeStreamDecoder.read(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean ready() throws IOException {
/* 166 */     return this.activeStreamDecoder.ready();
/*     */   }
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 170 */     return this.activeStreamDecoder.skip(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setEncoding(String paramString) throws IOException {
/*     */     try {
/* 176 */       this.encoding = paramString;
/* 177 */       this.decoder = XMLDecoderFactory.createDecoder(paramString);
/* 178 */       this.minBytesPerChar = this.decoder.minBytesPerChar();
/* 179 */       this.maxBytesPerChar = this.decoder.maxBytesPerChar();
/*     */     }
/* 181 */     catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/* 183 */       if (this.javaStreamDecoder == null)
/* 184 */         this.javaStreamDecoder = new JavaStreamDecoder(); 
/* 185 */       this.activeStreamDecoder = this.javaStreamDecoder;
/*     */     } 
/*     */     
/* 188 */     this.activeStreamDecoder.reset();
/*     */   }
/*     */   
/*     */   private int fillByteBuffer(boolean paramBoolean) throws IOException {
/* 192 */     int i = this.bbufEnd - this.bbufPos;
/* 193 */     if (i > 0) {
/* 194 */       System.arraycopy(this.bbuf, this.bbufPos, this.bbuf, 0, i);
/*     */     }
/* 196 */     this.bbufPos = 0;
/* 197 */     this.bbufEnd = i;
/*     */ 
/*     */ 
/*     */     
/* 201 */     int j = 0;
/*     */ 
/*     */ 
/*     */     
/* 205 */     int k = 0;
/*     */     
/* 207 */     while (this.bbufEnd < 8192 && k < 160) {
/*     */       
/* 209 */       if ((j = this.in.read(this.bbuf, this.bbufEnd, 8192 - this.bbufEnd)) != -1)
/*     */       {
/* 211 */         this.bbufEnd += j;
/*     */       }
/* 213 */       k += j;
/* 214 */       if (j == -1) {
/*     */         
/* 216 */         this.eofReached = true;
/*     */         break;
/*     */       } 
/* 219 */       if (!paramBoolean) {
/*     */         break;
/*     */       }
/*     */     } 
/* 223 */     return k;
/*     */   }
/*     */   
/* 226 */   private static HashMap charsetTable = new HashMap(31);
/*     */   static {
/* 228 */     charsetTable.put("EBCDIC-CP-US", "Cp037");
/* 229 */     charsetTable.put("EBCDIC-CP-CA", "Cp037");
/* 230 */     charsetTable.put("EBCDIC-CP-NL", "Cp037");
/* 231 */     charsetTable.put("EBCDIC-CP-WT", "Cp037");
/* 232 */     charsetTable.put("EBCDIC-CP-DK", "Cp277");
/* 233 */     charsetTable.put("EBCDIC-CP-NO", "Cp277");
/* 234 */     charsetTable.put("EBCDIC-CP-FI", "Cp278");
/* 235 */     charsetTable.put("EBCDIC-CP-SE", "Cp278");
/* 236 */     charsetTable.put("EBCDIC-CP-IT", "Cp280");
/* 237 */     charsetTable.put("EBCDIC-CP-ES", "Cp284");
/* 238 */     charsetTable.put("EBCDIC-CP-GB", "Cp285");
/* 239 */     charsetTable.put("EBCDIC-CP-FR", "Cp297");
/* 240 */     charsetTable.put("EBCDIC-CP-AR1", "Cp420");
/* 241 */     charsetTable.put("EBCDIC-CP-GR", "Cp423");
/* 242 */     charsetTable.put("EBCDIC-CP-HE", "Cp424");
/* 243 */     charsetTable.put("EBCDIC-CP-BE", "Cp500");
/* 244 */     charsetTable.put("EBCDIC-CP-CH", "Cp500");
/* 245 */     charsetTable.put("EBCDIC-CP-ROECE", "Cp870");
/* 246 */     charsetTable.put("EBCDIC-CP-YU", "Cp870");
/* 247 */     charsetTable.put("EBCDIC-CP-IS", "Cp871");
/* 248 */     charsetTable.put("EBCDIC-CP-TR", "Cp905");
/* 249 */     charsetTable.put("EBCDIC-CP-AR2", "Cp918");
/* 250 */     charsetTable.put("UTF-16", "Unicode");
/* 251 */     charsetTable.put("ISO-10646-UCS-2", "Unicode");
/*     */     
/* 253 */     charsetTable.put("ANSI_X3.4-1986", "ASCII");
/* 254 */     charsetTable.put("ASCII", "ASCII");
/* 255 */     charsetTable.put("CP367", "ASCII");
/* 256 */     charsetTable.put("CSASCII", "ASCII");
/* 257 */     charsetTable.put("IBM-367", "ASCII");
/* 258 */     charsetTable.put("IBM367", "ASCII");
/* 259 */     charsetTable.put("ISO-IR-6", "ASCII");
/* 260 */     charsetTable.put("ISO646-US", "ASCII");
/* 261 */     charsetTable.put("ISO_646.IRV:1991", "ASCII");
/* 262 */     charsetTable.put("US", "ASCII");
/* 263 */     charsetTable.put("US-ASCII", "ASCII");
/* 264 */     charsetTable.put("BIG5", "BIG5");
/* 265 */     charsetTable.put("CSBIG5", "BIG5");
/* 266 */     charsetTable.put("CP037", "CP037");
/* 267 */     charsetTable.put("CSIBM037", "CP037");
/* 268 */     charsetTable.put("IBM-37", "CP037");
/* 269 */     charsetTable.put("IBM037", "CP037");
/* 270 */     charsetTable.put("CP1026", "CP1026");
/* 271 */     charsetTable.put("CSIBM1026", "CP1026");
/* 272 */     charsetTable.put("IBM-1026", "CP1026");
/* 273 */     charsetTable.put("IBM1026", "CP1026");
/* 274 */     charsetTable.put("CP1047", "CP1047");
/* 275 */     charsetTable.put("IBM-1047", "CP1047");
/* 276 */     charsetTable.put("IBM1047", "CP1047");
/* 277 */     charsetTable.put("CCSID01140", "CP1140");
/* 278 */     charsetTable.put("CP01140", "CP1140");
/* 279 */     charsetTable.put("IBM-1140", "CP1140");
/* 280 */     charsetTable.put("IBM01140", "CP1140");
/* 281 */     charsetTable.put("CCSID01141", "CP1141");
/* 282 */     charsetTable.put("CP01141", "CP1141");
/* 283 */     charsetTable.put("IBM-1141", "CP1141");
/* 284 */     charsetTable.put("IBM01141", "CP1141");
/* 285 */     charsetTable.put("CCSID01142", "CP1142");
/* 286 */     charsetTable.put("CP01142", "CP1142");
/* 287 */     charsetTable.put("IBM-1142", "CP1142");
/* 288 */     charsetTable.put("IBM01142", "CP1142");
/* 289 */     charsetTable.put("CCSID01143", "CP1143");
/* 290 */     charsetTable.put("CP01143", "CP1143");
/* 291 */     charsetTable.put("IBM-1143", "CP1143");
/* 292 */     charsetTable.put("IBM01143", "CP1143");
/* 293 */     charsetTable.put("CCSID01144", "CP1144");
/* 294 */     charsetTable.put("CP01144", "CP1144");
/* 295 */     charsetTable.put("IBM-1144", "CP1144");
/* 296 */     charsetTable.put("IBM01144", "CP1144");
/* 297 */     charsetTable.put("CCSID01145", "CP1145");
/* 298 */     charsetTable.put("CP01145", "CP1145");
/* 299 */     charsetTable.put("IBM-1145", "CP1145");
/* 300 */     charsetTable.put("IBM01145", "CP1145");
/* 301 */     charsetTable.put("CCSID01146", "CP1146");
/* 302 */     charsetTable.put("CP01146", "CP1146");
/* 303 */     charsetTable.put("IBM-1146", "CP1146");
/* 304 */     charsetTable.put("IBM01146", "CP1146");
/* 305 */     charsetTable.put("CCSID01147", "CP1147");
/* 306 */     charsetTable.put("CP01147", "CP1147");
/* 307 */     charsetTable.put("IBM-1147", "CP1147");
/* 308 */     charsetTable.put("IBM01147", "CP1147");
/* 309 */     charsetTable.put("CCSID01148", "CP1148");
/* 310 */     charsetTable.put("CP01148", "CP1148");
/* 311 */     charsetTable.put("IBM-1148", "CP1148");
/* 312 */     charsetTable.put("IBM01148", "CP1148");
/* 313 */     charsetTable.put("CCSID01149", "CP1149");
/* 314 */     charsetTable.put("CP01149", "CP1149");
/* 315 */     charsetTable.put("IBM-1149", "CP1149");
/* 316 */     charsetTable.put("IBM01149", "CP1149");
/* 317 */     charsetTable.put("WINDOWS-1250", "CP1250");
/* 318 */     charsetTable.put("WINDOWS-1251", "CP1251");
/* 319 */     charsetTable.put("WINDOWS-1252", "CP1252");
/* 320 */     charsetTable.put("WINDOWS-1253", "CP1253");
/* 321 */     charsetTable.put("WINDOWS-1254", "CP1254");
/* 322 */     charsetTable.put("WINDOWS-1255", "CP1255");
/* 323 */     charsetTable.put("WINDOWS-1256", "CP1256");
/* 324 */     charsetTable.put("WINDOWS-1257", "CP1257");
/* 325 */     charsetTable.put("WINDOWS-1258", "CP1258");
/* 326 */     charsetTable.put("CP273", "CP273");
/* 327 */     charsetTable.put("CSIBM273", "CP273");
/* 328 */     charsetTable.put("IBM-273", "CP273");
/* 329 */     charsetTable.put("IBM273", "CP273");
/* 330 */     charsetTable.put("CP277", "CP277");
/* 331 */     charsetTable.put("CSIBM277", "CP277");
/* 332 */     charsetTable.put("IBM-277", "CP277");
/* 333 */     charsetTable.put("IBM277", "CP277");
/* 334 */     charsetTable.put("CP278", "CP278");
/* 335 */     charsetTable.put("CSIBM278", "CP278");
/* 336 */     charsetTable.put("IBM-278", "CP278");
/* 337 */     charsetTable.put("IBM278", "CP278");
/* 338 */     charsetTable.put("CP280", "CP280");
/* 339 */     charsetTable.put("CSIBM280", "CP280");
/* 340 */     charsetTable.put("IBM-280", "CP280");
/* 341 */     charsetTable.put("IBM280", "CP280");
/* 342 */     charsetTable.put("CP284", "CP284");
/* 343 */     charsetTable.put("CSIBM284", "CP284");
/* 344 */     charsetTable.put("IBM-284", "CP284");
/* 345 */     charsetTable.put("IBM284", "CP284");
/* 346 */     charsetTable.put("CP285", "CP285");
/* 347 */     charsetTable.put("CSIBM285", "CP285");
/* 348 */     charsetTable.put("IBM-285", "CP285");
/* 349 */     charsetTable.put("IBM285", "CP285");
/* 350 */     charsetTable.put("CP290", "CP290");
/* 351 */     charsetTable.put("CSIBM290", "CP290");
/* 352 */     charsetTable.put("EBCDIC-JP-KANA", "CP290");
/* 353 */     charsetTable.put("IBM-290", "CP290");
/* 354 */     charsetTable.put("IBM290", "CP290");
/* 355 */     charsetTable.put("CP297", "CP297");
/* 356 */     charsetTable.put("CSIBM297", "CP297");
/* 357 */     charsetTable.put("IBM-297", "CP297");
/* 358 */     charsetTable.put("IBM297", "CP297");
/* 359 */     charsetTable.put("CP420", "CP420");
/* 360 */     charsetTable.put("CSIBM420", "CP420");
/* 361 */     charsetTable.put("IBM-420", "CP420");
/* 362 */     charsetTable.put("IBM420", "CP420");
/* 363 */     charsetTable.put("CP424", "CP424");
/* 364 */     charsetTable.put("CSIBM424", "CP424");
/* 365 */     charsetTable.put("IBM-424", "CP424");
/* 366 */     charsetTable.put("IBM424", "CP424");
/* 367 */     charsetTable.put("437", "CP437");
/* 368 */     charsetTable.put("CP437", "CP437");
/* 369 */     charsetTable.put("CSPC8CODEPAGE437", "CP437");
/* 370 */     charsetTable.put("IBM-437", "CP437");
/* 371 */     charsetTable.put("IBM437", "CP437");
/* 372 */     charsetTable.put("CP500", "CP500");
/* 373 */     charsetTable.put("CSIBM500", "CP500");
/* 374 */     charsetTable.put("IBM-500", "CP500");
/* 375 */     charsetTable.put("IBM500", "CP500");
/* 376 */     charsetTable.put("CP775", "CP775");
/* 377 */     charsetTable.put("CSPC775BALTIC", "CP775");
/* 378 */     charsetTable.put("IBM-775", "CP775");
/* 379 */     charsetTable.put("IBM775", "CP775");
/* 380 */     charsetTable.put("850", "CP850");
/* 381 */     charsetTable.put("CP850", "CP850");
/* 382 */     charsetTable.put("CSPC850MULTILINGUAL", "CP850");
/* 383 */     charsetTable.put("IBM-850", "CP850");
/* 384 */     charsetTable.put("IBM850", "CP850");
/* 385 */     charsetTable.put("852", "CP852");
/* 386 */     charsetTable.put("CP852", "CP852");
/* 387 */     charsetTable.put("CSPCP852", "CP852");
/* 388 */     charsetTable.put("IBM-852", "CP852");
/* 389 */     charsetTable.put("IBM852", "CP852");
/* 390 */     charsetTable.put("855", "CP855");
/* 391 */     charsetTable.put("CP855", "CP855");
/* 392 */     charsetTable.put("CSIBM855", "CP855");
/* 393 */     charsetTable.put("IBM-855", "CP855");
/* 394 */     charsetTable.put("IBM855", "CP855");
/* 395 */     charsetTable.put("857", "CP857");
/* 396 */     charsetTable.put("CP857", "CP857");
/* 397 */     charsetTable.put("CSIBM857", "CP857");
/* 398 */     charsetTable.put("IBM-857", "CP857");
/* 399 */     charsetTable.put("IBM857", "CP857");
/* 400 */     charsetTable.put("CCSID00858", "CP858");
/* 401 */     charsetTable.put("CP00858", "CP858");
/* 402 */     charsetTable.put("IBM-858", "CP858");
/* 403 */     charsetTable.put("IBM00858", "CP858");
/* 404 */     charsetTable.put("860", "CP860");
/* 405 */     charsetTable.put("CP860", "CP860");
/* 406 */     charsetTable.put("CSIBM860", "CP860");
/* 407 */     charsetTable.put("IBM-860", "CP860");
/* 408 */     charsetTable.put("IBM860", "CP860");
/* 409 */     charsetTable.put("861", "CP861");
/* 410 */     charsetTable.put("CP-IS", "CP861");
/* 411 */     charsetTable.put("CP861", "CP861");
/* 412 */     charsetTable.put("CSIBM861", "CP861");
/* 413 */     charsetTable.put("IBM-861", "CP861");
/* 414 */     charsetTable.put("IBM861", "CP861");
/* 415 */     charsetTable.put("862", "CP862");
/* 416 */     charsetTable.put("CP862", "CP862");
/* 417 */     charsetTable.put("CSPC862LATINHEBREW", "CP862");
/* 418 */     charsetTable.put("IBM-862", "CP862");
/* 419 */     charsetTable.put("IBM862", "CP862");
/* 420 */     charsetTable.put("863", "CP863");
/* 421 */     charsetTable.put("CP863", "CP863");
/* 422 */     charsetTable.put("CSIBM863", "CP863");
/* 423 */     charsetTable.put("IBM-863", "CP863");
/* 424 */     charsetTable.put("IBM863", "CP863");
/* 425 */     charsetTable.put("CP864", "CP864");
/* 426 */     charsetTable.put("CSIBM864", "CP864");
/* 427 */     charsetTable.put("IBM-864", "CP864");
/* 428 */     charsetTable.put("IBM864", "CP864");
/* 429 */     charsetTable.put("865", "CP865");
/* 430 */     charsetTable.put("CP865", "CP865");
/* 431 */     charsetTable.put("CSIBM865", "CP865");
/* 432 */     charsetTable.put("IBM-865", "CP865");
/* 433 */     charsetTable.put("IBM865", "CP865");
/* 434 */     charsetTable.put("866", "CP866");
/* 435 */     charsetTable.put("CP866", "CP866");
/* 436 */     charsetTable.put("CSIBM866", "CP866");
/* 437 */     charsetTable.put("IBM-866", "CP866");
/* 438 */     charsetTable.put("IBM866", "CP866");
/* 439 */     charsetTable.put("CP-AR", "CP868");
/* 440 */     charsetTable.put("CP868", "CP868");
/* 441 */     charsetTable.put("CSIBM868", "CP868");
/* 442 */     charsetTable.put("IBM-868", "CP868");
/* 443 */     charsetTable.put("IBM868", "CP868");
/* 444 */     charsetTable.put("CP-GR", "CP869");
/* 445 */     charsetTable.put("CP869", "CP869");
/* 446 */     charsetTable.put("CSIBM869", "CP869");
/* 447 */     charsetTable.put("IBM-869", "CP869");
/* 448 */     charsetTable.put("IBM869", "CP869");
/* 449 */     charsetTable.put("CP870", "CP870");
/* 450 */     charsetTable.put("CSIBM870", "CP870");
/* 451 */     charsetTable.put("IBM-870", "CP870");
/* 452 */     charsetTable.put("IBM870", "CP870");
/* 453 */     charsetTable.put("CP871", "CP871");
/* 454 */     charsetTable.put("CSIBM871", "CP871");
/* 455 */     charsetTable.put("IBM-871", "CP871");
/* 456 */     charsetTable.put("IBM871", "CP871");
/* 457 */     charsetTable.put("CP918", "CP918");
/* 458 */     charsetTable.put("CSIBM918", "CP918");
/* 459 */     charsetTable.put("IBM-918", "CP918");
/* 460 */     charsetTable.put("IBM918", "CP918");
/* 461 */     charsetTable.put("CCSID00924", "CP924");
/* 462 */     charsetTable.put("CP00924", "CP924");
/* 463 */     charsetTable.put("EBCDIC-LATIN9--EURO", "CP924");
/* 464 */     charsetTable.put("IBM-924", "CP924");
/* 465 */     charsetTable.put("IBM00924", "CP924");
/* 466 */     charsetTable.put("CSEUCPKDFMTJAPANESE", "EUCJIS");
/* 467 */     charsetTable.put("EUC-JP", "EUCJIS");
/* 468 */     charsetTable.put("EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE", "EUCJIS");
/* 469 */     charsetTable.put("GB18030", "GB18030");
/* 470 */     charsetTable.put("CSGB2312", "GB2312");
/* 471 */     charsetTable.put("GB2312", "GB2312");
/* 472 */     charsetTable.put("ISO-2022-CN", "ISO2022CN");
/* 473 */     charsetTable.put("CSISO2022KR", "ISO2022KR");
/* 474 */     charsetTable.put("ISO-2022-KR", "ISO2022KR");
/* 475 */     charsetTable.put("CP819", "ISO8859_1");
/* 476 */     charsetTable.put("CSISOLATIN1", "ISO8859_1");
/* 477 */     charsetTable.put("IBM-819", "ISO8859_1");
/* 478 */     charsetTable.put("IBM819", "ISO8859_1");
/* 479 */     charsetTable.put("ISO-8859-1", "ISO8859_1");
/* 480 */     charsetTable.put("ISO-IR-100", "ISO8859_1");
/* 481 */     charsetTable.put("ISO_8859-1", "ISO8859_1");
/* 482 */     charsetTable.put("L1", "ISO8859_1");
/* 483 */     charsetTable.put("LATIN1", "ISO8859_1");
/* 484 */     charsetTable.put("CSISOLATIN2", "ISO8859_2");
/* 485 */     charsetTable.put("ISO-8859-2", "ISO8859_2");
/* 486 */     charsetTable.put("ISO-IR-101", "ISO8859_2");
/* 487 */     charsetTable.put("ISO_8859-2", "ISO8859_2");
/* 488 */     charsetTable.put("L2", "ISO8859_2");
/* 489 */     charsetTable.put("LATIN2", "ISO8859_2");
/* 490 */     charsetTable.put("CSISOLATIN3", "ISO8859_3");
/* 491 */     charsetTable.put("ISO-8859-3", "ISO8859_3");
/* 492 */     charsetTable.put("ISO-IR-109", "ISO8859_3");
/* 493 */     charsetTable.put("ISO_8859-3", "ISO8859_3");
/* 494 */     charsetTable.put("L3", "ISO8859_3");
/* 495 */     charsetTable.put("LATIN3", "ISO8859_3");
/* 496 */     charsetTable.put("CSISOLATIN4", "ISO8859_4");
/* 497 */     charsetTable.put("ISO-8859-4", "ISO8859_4");
/* 498 */     charsetTable.put("ISO-IR-110", "ISO8859_4");
/* 499 */     charsetTable.put("ISO_8859-4", "ISO8859_4");
/* 500 */     charsetTable.put("L4", "ISO8859_4");
/* 501 */     charsetTable.put("LATIN4", "ISO8859_4");
/* 502 */     charsetTable.put("CSISOLATINCYRILLIC", "ISO8859_5");
/* 503 */     charsetTable.put("CYRILLIC", "ISO8859_5");
/* 504 */     charsetTable.put("ISO-8859-5", "ISO8859_5");
/* 505 */     charsetTable.put("ISO-IR-144", "ISO8859_5");
/* 506 */     charsetTable.put("ISO_8859-5", "ISO8859_5");
/* 507 */     charsetTable.put("ARABIC", "ISO8859_6");
/* 508 */     charsetTable.put("ASMO-708", "ISO8859_6");
/* 509 */     charsetTable.put("CSISOLATINARABIC", "ISO8859_6");
/* 510 */     charsetTable.put("ECMA-114", "ISO8859_6");
/* 511 */     charsetTable.put("ISO-8859-6", "ISO8859_6");
/* 512 */     charsetTable.put("ISO-IR-127", "ISO8859_6");
/* 513 */     charsetTable.put("ISO_8859-6", "ISO8859_6");
/* 514 */     charsetTable.put("CSISOLATINGREEK", "ISO8859_7");
/* 515 */     charsetTable.put("ECMA-118", "ISO8859_7");
/* 516 */     charsetTable.put("ELOT_928", "ISO8859_7");
/* 517 */     charsetTable.put("GREEK", "ISO8859_7");
/* 518 */     charsetTable.put("GREEK8", "ISO8859_7");
/* 519 */     charsetTable.put("ISO-8859-7", "ISO8859_7");
/* 520 */     charsetTable.put("ISO-IR-126", "ISO8859_7");
/* 521 */     charsetTable.put("ISO_8859-7", "ISO8859_7");
/* 522 */     charsetTable.put("CSISOLATINHEBREW", "ISO8859_8");
/* 523 */     charsetTable.put("HEBREW", "ISO8859_8");
/* 524 */     charsetTable.put("ISO-8859-8", "ISO8859_8");
/* 525 */     charsetTable.put("ISO-8859-8-I", "ISO8859_8");
/* 526 */     charsetTable.put("ISO-IR-138", "ISO8859_8");
/* 527 */     charsetTable.put("ISO_8859-8", "ISO8859_8");
/* 528 */     charsetTable.put("CSISOLATIN5", "ISO8859_9");
/* 529 */     charsetTable.put("ISO-8859-9", "ISO8859_9");
/* 530 */     charsetTable.put("ISO-IR-148", "ISO8859_9");
/* 531 */     charsetTable.put("ISO_8859-9", "ISO8859_9");
/* 532 */     charsetTable.put("L5", "ISO8859_9");
/* 533 */     charsetTable.put("LATIN5", "ISO8859_9");
/* 534 */     charsetTable.put("CSISO2022JP", "JIS");
/* 535 */     charsetTable.put("ISO-2022-JP", "JIS");
/* 536 */     charsetTable.put("CSISO13JISC6220JP", "JIS0201");
/* 537 */     charsetTable.put("X0201", "JIS0201");
/* 538 */     charsetTable.put("CSISO87JISX0208", "JIS0208");
/* 539 */     charsetTable.put("ISO-IR-87", "JIS0208");
/* 540 */     charsetTable.put("X0208", "JIS0208");
/* 541 */     charsetTable.put("X0208DBIJIS_X0208-1983", "JIS0208");
/* 542 */     charsetTable.put("CSISO159JISX02121990", "JIS0212");
/* 543 */     charsetTable.put("ISO-IR-159", "JIS0212");
/* 544 */     charsetTable.put("X0212", "JIS0212");
/* 545 */     charsetTable.put("CSKOI8R", "KOI8_R");
/* 546 */     charsetTable.put("KOI8-R", "KOI8_R");
/* 547 */     charsetTable.put("EUC-KR", "KSC5601");
/* 548 */     charsetTable.put("CSWINDOWS31J", "MS932");
/* 549 */     charsetTable.put("WINDOWS-31J", "MS932");
/* 550 */     charsetTable.put("CSSHIFTJIS", "SJIS");
/* 551 */     charsetTable.put("MS_KANJI", "SJIS");
/* 552 */     charsetTable.put("SHIFT_JIS", "SJIS");
/* 553 */     charsetTable.put("TIS-620", "TIS620");
/* 554 */     charsetTable.put("UTF-16BE", "UNICODEBIG");
/* 555 */     charsetTable.put("UTF-16LE", "UNICODELITTLE");
/* 556 */     charsetTable.put("UTF-8", "UTF8");
/*     */   }
/*     */ 
/*     */   
/*     */   private String getJavaCharset(String paramString) {
/* 561 */     if (paramString == null)
/* 562 */       return null; 
/* 563 */     String str = (String)charsetTable.get(paramString.toUpperCase());
/* 564 */     if (str != null) {
/* 565 */       return str;
/*     */     }
/* 567 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String guessEncoding() {
/* 574 */     if (this.bbufEnd < 4)
/* 575 */       return null; 
/* 576 */     switch (this.bbuf[0]) {
/*     */       case -17:
/* 578 */         if (this.bbuf[1] == -69 && this.bbuf[2] == -65) {
/* 579 */           this.bbufPos = 3;
/* 580 */           return "UTF-8";
/*     */         } 
/*     */         
/* 583 */         return null;
/*     */       case 60:
/* 585 */         switch (this.bbuf[1]) {
/*     */           
/*     */           case 63:
/* 588 */             if (this.bbuf[2] == 120 && this.bbuf[3] == 109) {
/* 589 */               this.useDeclaredEncoding = true;
/* 590 */               return "UTF-8";
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 595 */             return null;
/*     */           case 0:
/* 597 */             if (this.bbuf[2] == 63 && this.bbuf[3] == 0)
/* 598 */               return "UnicodeLittleUnmarked"; 
/* 599 */             if (this.bbuf[2] == 0 && this.bbuf[3] == 0) {
/* 600 */               return "UCS-4";
/*     */             }
/* 602 */             return null;
/*     */         } 
/* 604 */         return null;
/*     */       
/*     */       case -2:
/* 607 */         if (this.bbuf[1] == -1) {
/* 608 */           if (this.bbuf[2] == 0 && this.bbuf[3] == 0) {
/* 609 */             this.bbufPos = 4;
/* 610 */             return "UCS-4";
/*     */           } 
/*     */           
/* 613 */           this.bbufPos = 2;
/* 614 */           return "UnicodeBig";
/*     */         } 
/*     */ 
/*     */         
/* 618 */         return null;
/*     */       case -1:
/* 620 */         if (this.bbuf[1] == -2) {
/* 621 */           if (this.bbuf[2] == 0 && this.bbuf[3] == 0) {
/* 622 */             this.bbufPos = 4;
/* 623 */             return "UCS-4";
/*     */           } 
/*     */           
/* 626 */           this.bbufPos = 2;
/* 627 */           return "UnicodeLittle";
/*     */         } 
/*     */ 
/*     */         
/* 631 */         return null;
/*     */       
/*     */       case 0:
/* 634 */         switch (this.bbuf[1]) {
/*     */           case 0:
/* 636 */             if (this.bbuf[2] == -2 && this.bbuf[3] == -1) {
/* 637 */               this.bbufPos = 4;
/* 638 */               return "UCS-4";
/*     */             } 
/* 640 */             if (this.bbuf[2] == -1 && this.bbuf[3] == -2) {
/* 641 */               this.bbufPos = 4;
/* 642 */               return "UCS-4";
/*     */             } 
/*     */             
/* 645 */             if ((this.bbuf[2] == 60 && this.bbuf[3] == 0) || (this.bbuf[2] == 0 && this.bbuf[3] == 60))
/*     */             {
/* 647 */               return "UCS-4";
/*     */             }
/* 649 */             return null;
/*     */           case 60:
/* 651 */             if (this.bbuf[2] == 0 && this.bbuf[3] == 63)
/* 652 */               return "UnicodeBigUnmarked"; 
/* 653 */             if (this.bbuf[2] == 0 && this.bbuf[3] == 0) {
/* 654 */               return "UCS-4";
/*     */             }
/* 656 */             return null;
/*     */         } 
/* 658 */         return null;
/*     */       
/*     */       case 76:
/* 661 */         if (this.bbuf[1] == 111 && this.bbuf[2] == -89 && this.bbuf[3] == -108) {
/*     */           
/* 663 */           this.useDeclaredEncoding = true;
/* 664 */           return "Cp037";
/*     */         } 
/*     */         
/* 667 */         return null;
/*     */     } 
/* 669 */     this.useDeclaredEncoding = true;
/* 670 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processXMLDecl() throws IOException {
/* 679 */     int i = this.bbufPos;
/*     */     
/* 681 */     this.decoder.decodeXMLDecl(this.bbuf, this.bbufPos, this.bbufEnd - this.bbufPos, this.cbuf, this.cbufPos, this.cbuf.length, this.decodeResult);
/*     */ 
/*     */     
/* 684 */     this.bbufPos += this.decodeResult[0];
/* 685 */     this.cbufEnd = this.decodeResult[1];
/*     */     
/* 687 */     int j = parseXMLDeclaration(this.cbuf, 0, this.cbufEnd);
/*     */     
/* 689 */     if (j > 0) {
/*     */ 
/*     */       
/* 692 */       String str = getJavaCharset(getXMLDeclaredEncoding());
/*     */ 
/*     */       
/* 695 */       if (!this.rewindDeclaration) {
/* 696 */         this.cbufPos += j;
/*     */       }
/*     */       
/* 699 */       if (this.useDeclaredEncoding && str != null && !str.equalsIgnoreCase(this.encoding)) {
/*     */ 
/*     */ 
/*     */         
/* 703 */         this.cbufPos = this.cbufEnd = 0;
/* 704 */         this.decoder.reset();
/*     */ 
/*     */         
/* 707 */         if (this.rewindDeclaration) {
/* 708 */           this.bbufPos = i;
/*     */         } else {
/* 710 */           this.bbufPos = j * this.minBytesPerChar;
/*     */         } 
/* 712 */         setEncoding(str);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public XMLStreamReader() {}
/*     */   
/*     */   private static interface XMLStreamDecoder {
/*     */     int read() throws IOException;
/*     */     
/*     */     int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException;
/*     */     
/*     */     boolean ready() throws IOException;
/*     */     
/*     */     long skip(long param1Long) throws IOException;
/*     */     
/*     */     void reset() throws IOException; }
/*     */   
/*     */   private class FastStreamDecoder implements XMLStreamDecoder {
/*     */     public int read() throws IOException {
/* 732 */       if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0) {
/* 733 */         return XMLStreamReader.this.cbuf[XMLStreamReader.this.cbufPos++];
/*     */       }
/* 735 */       XMLStreamReader.this.cbufPos = XMLStreamReader.this.cbufEnd = 0;
/* 736 */       XMLStreamReader.this.cbufEnd = read(XMLStreamReader.this.cbuf, XMLStreamReader.this.cbufPos, 100);
/* 737 */       if (XMLStreamReader.this.cbufEnd > 0) {
/* 738 */         return XMLStreamReader.this.cbuf[XMLStreamReader.this.cbufPos++];
/*     */       }
/* 740 */       return -1;
/*     */     }
/*     */     private final XMLStreamReader this$0;
/*     */     public void reset() {}
/*     */     
/*     */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 746 */       int i = 0;
/*     */       
/* 748 */       if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0) {
/* 749 */         int j = Math.min(XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos, param1Int2 - i);
/* 750 */         if (j > 0) {
/* 751 */           System.arraycopy(XMLStreamReader.this.cbuf, XMLStreamReader.this.cbufPos, param1ArrayOfchar, param1Int1, j);
/* 752 */           i += j;
/* 753 */           XMLStreamReader.this.cbufPos += j;
/*     */         } 
/*     */       } 
/* 756 */       if (i < param1Int2) {
/* 757 */         if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos < XMLStreamReader.this.maxBytesPerChar) {
/* 758 */           XMLStreamReader.this.fillByteBuffer(false);
/* 759 */           if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos < XMLStreamReader.this.minBytesPerChar)
/* 760 */             return (i <= 0) ? -1 : i; 
/*     */         } 
/* 762 */         XMLStreamReader.this.decoder.decode(XMLStreamReader.this.bbuf, XMLStreamReader.this.bbufPos, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos, param1ArrayOfchar, param1Int1 + i, param1Int2 - i, XMLStreamReader.this.decodeResult);
/*     */         
/* 764 */         XMLStreamReader.this.bbufPos += XMLStreamReader.this.decodeResult[0];
/* 765 */         i += XMLStreamReader.this.decodeResult[1];
/*     */       } 
/* 767 */       return (i == 0 && XMLStreamReader.this.eofReached) ? -1 : i;
/*     */     }
/*     */     
/*     */     public boolean ready() throws IOException {
/* 771 */       return (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0 || XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos > XMLStreamReader.this.maxBytesPerChar || XMLStreamReader.this.in.available() > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 776 */       long l = 0L;
/* 777 */       if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0) {
/* 778 */         l = Math.min(XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos, param1Long);
/* 779 */         XMLStreamReader.access$114(XMLStreamReader.this, l);
/*     */       } 
/* 781 */       while (l < param1Long) {
/* 782 */         XMLStreamReader.this.cbufPos = 0;
/* 783 */         XMLStreamReader.this.cbufEnd = read(XMLStreamReader.this.cbuf, 0, 100);
/* 784 */         if (XMLStreamReader.this.cbufEnd > 0) {
/* 785 */           XMLStreamReader.this.cbufPos = (int)Math.min(XMLStreamReader.this.cbufEnd, param1Long - l);
/* 786 */           l += XMLStreamReader.this.cbufPos;
/*     */           continue;
/*     */         } 
/* 789 */         XMLStreamReader.this.cbufEnd = 0;
/* 790 */         return l;
/*     */       } 
/*     */       
/* 793 */       return l;
/*     */     }
/*     */   }
/*     */   
/*     */   private class JavaStreamDecoder
/*     */     implements XMLStreamDecoder {
/*     */     private Reader reader;
/* 800 */     char[] oneCharBuffer = new char[1];
/*     */     
/*     */     boolean sawCR;
/*     */     
/*     */     private final XMLStreamReader this$0;
/*     */     
/*     */     public void reset() throws IOException {
/* 807 */       this.sawCR = false;
/*     */       
/* 809 */       if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos > 0) {
/* 810 */         PushbackInputStream pushbackInputStream = new PushbackInputStream(XMLStreamReader.this.in, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos);
/* 811 */         pushbackInputStream.unread(XMLStreamReader.this.bbuf, XMLStreamReader.this.bbufPos, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos);
/* 812 */         this.reader = new InputStreamReader(pushbackInputStream, XMLStreamReader.this.encoding);
/*     */       } else {
/*     */         
/* 815 */         this.reader = new InputStreamReader(XMLStreamReader.this.in, XMLStreamReader.this.encoding);
/*     */       } 
/*     */     }
/*     */     
/*     */     public int read() throws IOException {
/*     */       while (true) {
/* 821 */         int i = read(this.oneCharBuffer, 0, 1);
/* 822 */         if (i > 0) {
/* 823 */           return this.oneCharBuffer[0];
/*     */         }
/* 825 */         if (i < 0)
/* 826 */           return i; 
/*     */       } 
/*     */     }
/*     */     
/*     */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 831 */       int i = this.reader.read(param1ArrayOfchar, param1Int1, param1Int2);
/* 832 */       int j = param1Int1;
/*     */ 
/*     */ 
/*     */       
/* 836 */       if (i < 0) {
/* 837 */         return i;
/*     */       }
/* 839 */       for (byte b = 0; b < i; b++) {
/* 840 */         int k = b + param1Int1;
/* 841 */         char c = param1ArrayOfchar[k];
/*     */         
/* 843 */         if (c >= ' ') {
/* 844 */           if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */             
/* 847 */             this.sawCR = false;
/* 848 */             if (k != j) {
/* 849 */               param1ArrayOfchar[j] = c;
/*     */             }
/* 851 */             j++;
/*     */           } else {
/*     */             
/* 854 */             throw new IllegalCharException("Illegal XML Character: 0x" + Integer.toHexString(c));
/*     */           } 
/*     */         } else {
/*     */           
/* 858 */           switch (c) {
/*     */             case '\n':
/* 860 */               if (this.sawCR) {
/* 861 */                 this.sawCR = false;
/*     */                 break;
/*     */               } 
/* 864 */               param1ArrayOfchar[j++] = '\n';
/*     */               break;
/*     */             
/*     */             case '\r':
/* 868 */               this.sawCR = true;
/* 869 */               param1ArrayOfchar[j++] = '\n';
/*     */               break;
/*     */             
/*     */             case '\t':
/* 873 */               param1ArrayOfchar[j++] = '\t';
/*     */               break;
/*     */             
/*     */             default:
/* 877 */               System.out.println("Char: " + c + " [" + c + "]");
/*     */               
/* 879 */               throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */           } 
/*     */ 
/*     */ 
/*     */         
/*     */         } 
/*     */       } 
/* 886 */       return j - param1Int1;
/*     */     }
/*     */     public boolean ready() throws IOException {
/* 889 */       return this.reader.ready();
/*     */     }
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 893 */       long l = 0L;
/* 894 */       while (l < param1Long) {
/* 895 */         XMLStreamReader.this.cbufEnd = read(XMLStreamReader.this.cbuf, 0, (int)Math.min(param1Long, 100L));
/* 896 */         if (XMLStreamReader.this.cbufEnd > 0) {
/* 897 */           l += XMLStreamReader.this.cbufEnd; continue;
/*     */         } 
/* 899 */         return l;
/*     */       } 
/* 901 */       return l;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLStreamReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */