/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.HexRead;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public final class EscherDump
/*     */ {
/*     */   public void dump(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, PrintStream paramPrintStream) {
/*  50 */     DefaultEscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
/*  51 */     int i = paramInt1;
/*  52 */     while (i < paramInt1 + paramInt2) {
/*     */       
/*  54 */       EscherRecord escherRecord = defaultEscherRecordFactory.createRecord(paramArrayOfbyte, i);
/*  55 */       int j = escherRecord.fillFields(paramArrayOfbyte, i, defaultEscherRecordFactory);
/*  56 */       paramPrintStream.println(escherRecord.toString());
/*  57 */       i += j;
/*     */     } 
/*     */   }
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
/*     */   public void dumpOld(long paramLong, InputStream paramInputStream, PrintStream paramPrintStream) throws IOException, LittleEndian.BufferUnderrunException {
/*  73 */     long l = paramLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     boolean bool = false;
/*     */     
/*  82 */     while (!bool && l > 0L) {
/*  83 */       String str; short s1 = LittleEndian.readShort(paramInputStream);
/*  84 */       short s2 = LittleEndian.readShort(paramInputStream);
/*  85 */       int i = LittleEndian.readInt(paramInputStream);
/*     */       
/*  87 */       l -= 8L;
/*     */       
/*  89 */       switch (s2) {
/*     */         
/*     */         case -4096:
/*  92 */           str = "MsofbtDggContainer";
/*     */           break;
/*     */         case -4090:
/*  95 */           str = "MsofbtDgg";
/*     */           break;
/*     */         case -4074:
/*  98 */           str = "MsofbtCLSID";
/*     */           break;
/*     */         case -4085:
/* 101 */           str = "MsofbtOPT";
/*     */           break;
/*     */         case -3814:
/* 104 */           str = "MsofbtColorMRU";
/*     */           break;
/*     */         case -3810:
/* 107 */           str = "MsofbtSplitMenuColors";
/*     */           break;
/*     */         case -4095:
/* 110 */           str = "MsofbtBstoreContainer";
/*     */           break;
/*     */         case -4089:
/* 113 */           str = "MsofbtBSE";
/*     */           break;
/*     */         case -4094:
/* 116 */           str = "MsofbtDgContainer";
/*     */           break;
/*     */         case -4088:
/* 119 */           str = "MsofbtDg";
/*     */           break;
/*     */         case -3816:
/* 122 */           str = "MsofbtRegroupItem";
/*     */           break;
/*     */         case -3808:
/* 125 */           str = "MsofbtColorScheme";
/*     */           break;
/*     */         case -4093:
/* 128 */           str = "MsofbtSpgrContainer";
/*     */           break;
/*     */         case -4092:
/* 131 */           str = "MsofbtSpContainer";
/*     */           break;
/*     */         case -4087:
/* 134 */           str = "MsofbtSpgr";
/*     */           break;
/*     */         case -4086:
/* 137 */           str = "MsofbtSp";
/*     */           break;
/*     */         case -4084:
/* 140 */           str = "MsofbtTextbox";
/*     */           break;
/*     */         case -4083:
/* 143 */           str = "MsofbtClientTextbox";
/*     */           break;
/*     */         case -4082:
/* 146 */           str = "MsofbtAnchor";
/*     */           break;
/*     */         case -4081:
/* 149 */           str = "MsofbtChildAnchor";
/*     */           break;
/*     */         case -4080:
/* 152 */           str = "MsofbtClientAnchor";
/*     */           break;
/*     */         case -4079:
/* 155 */           str = "MsofbtClientData";
/*     */           break;
/*     */         case -3809:
/* 158 */           str = "MsofbtOleObject";
/*     */           break;
/*     */         case -3811:
/* 161 */           str = "MsofbtDeletedPspl";
/*     */           break;
/*     */         case -4091:
/* 164 */           str = "MsofbtSolverContainer";
/*     */           break;
/*     */         case -4078:
/* 167 */           str = "MsofbtConnectorRule";
/*     */           break;
/*     */         case -4077:
/* 170 */           str = "MsofbtAlignRule";
/*     */           break;
/*     */         case -4076:
/* 173 */           str = "MsofbtArcRule";
/*     */           break;
/*     */         case -4075:
/* 176 */           str = "MsofbtClientRule";
/*     */           break;
/*     */         case -4073:
/* 179 */           str = "MsofbtCalloutRule";
/*     */           break;
/*     */         case -3815:
/* 182 */           str = "MsofbtSelection";
/*     */           break;
/*     */         case -3806:
/* 185 */           str = "MsofbtUDefProp";
/*     */           break;
/*     */         default:
/* 188 */           if (s2 >= -4072 && s2 <= -3817) {
/* 189 */             str = "MsofbtBLIP"; break;
/* 190 */           }  if ((s1 & 0xF) == 15) {
/* 191 */             str = "UNKNOWN container"; break;
/*     */           } 
/* 193 */           str = "UNKNOWN ID";
/*     */           break;
/*     */       } 
/* 196 */       StringBuilder stringBuilder = new StringBuilder();
/* 197 */       stringBuilder.append("  ");
/* 198 */       stringBuilder.append(HexDump.toHex(s2));
/* 199 */       stringBuilder.append("  ").append(str).append(" [");
/* 200 */       stringBuilder.append(HexDump.toHex(s1));
/* 201 */       stringBuilder.append(',');
/* 202 */       stringBuilder.append(HexDump.toHex(i));
/* 203 */       stringBuilder.append("]  instance: ");
/* 204 */       stringBuilder.append(HexDump.toHex((short)(s1 >> 4)));
/* 205 */       paramPrintStream.println(stringBuilder.toString());
/* 206 */       stringBuilder.setLength(0);
/*     */ 
/*     */       
/* 209 */       if (s2 == -4089 && 36L <= l && 36 <= i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 217 */         stringBuilder = stringBuilder.append("    btWin32: ");
/* 218 */         byte b = (byte)paramInputStream.read();
/* 219 */         stringBuilder.append(HexDump.toHex(b));
/* 220 */         stringBuilder.append(getBlipType(b));
/* 221 */         stringBuilder.append("  btMacOS: ");
/* 222 */         b = (byte)paramInputStream.read();
/* 223 */         stringBuilder.append(HexDump.toHex(b));
/* 224 */         stringBuilder.append(getBlipType(b));
/* 225 */         paramPrintStream.println(stringBuilder.toString());
/*     */         
/* 227 */         paramPrintStream.println("    rgbUid:");
/* 228 */         HexDump.dump(paramInputStream, paramPrintStream, 0, 16);
/*     */         
/* 230 */         paramPrintStream.print("    tag: ");
/* 231 */         outHex(2, paramInputStream, paramPrintStream);
/* 232 */         paramPrintStream.println();
/* 233 */         paramPrintStream.print("    size: ");
/* 234 */         outHex(4, paramInputStream, paramPrintStream);
/* 235 */         paramPrintStream.println();
/* 236 */         paramPrintStream.print("    cRef: ");
/* 237 */         outHex(4, paramInputStream, paramPrintStream);
/* 238 */         paramPrintStream.println();
/* 239 */         paramPrintStream.print("    offs: ");
/* 240 */         outHex(4, paramInputStream, paramPrintStream);
/* 241 */         paramPrintStream.println();
/* 242 */         paramPrintStream.print("    usage: ");
/* 243 */         outHex(1, paramInputStream, paramPrintStream);
/* 244 */         paramPrintStream.println();
/* 245 */         paramPrintStream.print("    cbName: ");
/* 246 */         outHex(1, paramInputStream, paramPrintStream);
/* 247 */         paramPrintStream.println();
/* 248 */         paramPrintStream.print("    unused2: ");
/* 249 */         outHex(1, paramInputStream, paramPrintStream);
/* 250 */         paramPrintStream.println();
/* 251 */         paramPrintStream.print("    unused3: ");
/* 252 */         outHex(1, paramInputStream, paramPrintStream);
/* 253 */         paramPrintStream.println();
/*     */ 
/*     */         
/* 256 */         l -= 36L;
/*     */         
/* 258 */         i = 0;
/*     */       }
/* 260 */       else if (s2 == -4080 && 18L <= l && 18 <= i) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 265 */         paramPrintStream.print("    Flag: ");
/* 266 */         outHex(2, paramInputStream, paramPrintStream);
/* 267 */         paramPrintStream.println();
/* 268 */         paramPrintStream.print("    Col1: ");
/* 269 */         outHex(2, paramInputStream, paramPrintStream);
/* 270 */         paramPrintStream.print("    dX1: ");
/* 271 */         outHex(2, paramInputStream, paramPrintStream);
/* 272 */         paramPrintStream.print("    Row1: ");
/* 273 */         outHex(2, paramInputStream, paramPrintStream);
/* 274 */         paramPrintStream.print("    dY1: ");
/* 275 */         outHex(2, paramInputStream, paramPrintStream);
/* 276 */         paramPrintStream.println();
/* 277 */         paramPrintStream.print("    Col2: ");
/* 278 */         outHex(2, paramInputStream, paramPrintStream);
/* 279 */         paramPrintStream.print("    dX2: ");
/* 280 */         outHex(2, paramInputStream, paramPrintStream);
/* 281 */         paramPrintStream.print("    Row2: ");
/* 282 */         outHex(2, paramInputStream, paramPrintStream);
/* 283 */         paramPrintStream.print("    dY2: ");
/* 284 */         outHex(2, paramInputStream, paramPrintStream);
/* 285 */         paramPrintStream.println();
/*     */         
/* 287 */         l -= 18L;
/* 288 */         i -= 18;
/*     */       
/*     */       }
/* 291 */       else if (s2 == -4085 || s2 == -3806) {
/*     */         
/* 293 */         int j = 0;
/* 294 */         paramPrintStream.println("    PROPID        VALUE");
/* 295 */         while (i >= 6 + j && l >= (6 + j)) {
/*     */ 
/*     */ 
/*     */           
/* 299 */           short s = LittleEndian.readShort(paramInputStream);
/* 300 */           int k = LittleEndian.readInt(paramInputStream);
/*     */           
/* 302 */           i -= 6;
/* 303 */           l -= 6L;
/* 304 */           paramPrintStream.print("    ");
/* 305 */           paramPrintStream.print(HexDump.toHex(s));
/* 306 */           paramPrintStream.print(" (");
/* 307 */           int m = s & 0x3FFF;
/* 308 */           paramPrintStream.print(" " + m);
/* 309 */           if ((s & Short.MIN_VALUE) == 0) {
/*     */             
/* 311 */             if ((s & 0x4000) != 0)
/* 312 */               paramPrintStream.print(", fBlipID"); 
/* 313 */             paramPrintStream.print(")  ");
/*     */             
/* 315 */             paramPrintStream.print(HexDump.toHex(k));
/*     */             
/* 317 */             if ((s & 0x4000) == 0) {
/*     */               
/* 319 */               paramPrintStream.print(" (");
/* 320 */               paramPrintStream.print(dec1616(k));
/* 321 */               paramPrintStream.print(')');
/* 322 */               paramPrintStream.print(" {" + propName((short)m) + "}");
/*     */             } 
/* 324 */             paramPrintStream.println();
/*     */             
/*     */             continue;
/*     */           } 
/* 328 */           paramPrintStream.print(", fComplex)  ");
/* 329 */           paramPrintStream.print(HexDump.toHex(k));
/* 330 */           paramPrintStream.print(" - Complex prop len");
/* 331 */           paramPrintStream.println(" {" + propName((short)m) + "}");
/*     */           
/* 333 */           j += k;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 338 */         while ((j & l) > 0L)
/*     */         {
/* 340 */           short s = (j > (int)l) ? (short)(int)l : (short)j;
/* 341 */           HexDump.dump(paramInputStream, paramPrintStream, 0, s);
/* 342 */           j -= s;
/* 343 */           i -= s;
/* 344 */           l -= s;
/*     */         }
/*     */       
/* 347 */       } else if (s2 == -4078) {
/*     */         
/* 349 */         paramPrintStream.print("    Connector rule: ");
/* 350 */         paramPrintStream.print(LittleEndian.readInt(paramInputStream));
/* 351 */         paramPrintStream.print("    ShapeID A: ");
/* 352 */         paramPrintStream.print(LittleEndian.readInt(paramInputStream));
/* 353 */         paramPrintStream.print("   ShapeID B: ");
/* 354 */         paramPrintStream.print(LittleEndian.readInt(paramInputStream));
/* 355 */         paramPrintStream.print("    ShapeID connector: ");
/* 356 */         paramPrintStream.print(LittleEndian.readInt(paramInputStream));
/* 357 */         paramPrintStream.print("   Connect pt A: ");
/* 358 */         paramPrintStream.print(LittleEndian.readInt(paramInputStream));
/* 359 */         paramPrintStream.print("   Connect pt B: ");
/* 360 */         paramPrintStream.println(LittleEndian.readInt(paramInputStream));
/*     */         
/* 362 */         i -= 24;
/* 363 */         l -= 24L;
/*     */       }
/* 365 */       else if (s2 >= -4072 && s2 < -3817) {
/*     */         
/* 367 */         paramPrintStream.println("    Secondary UID: ");
/* 368 */         HexDump.dump(paramInputStream, paramPrintStream, 0, 16);
/* 369 */         paramPrintStream.println("    Cache of size: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 370 */         paramPrintStream.println("    Boundary top: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 371 */         paramPrintStream.println("    Boundary left: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 372 */         paramPrintStream.println("    Boundary width: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 373 */         paramPrintStream.println("    Boundary height: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 374 */         paramPrintStream.println("    X: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 375 */         paramPrintStream.println("    Y: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 376 */         paramPrintStream.println("    Cache of saved size: " + HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/* 377 */         paramPrintStream.println("    Compression Flag: " + HexDump.toHex((byte)paramInputStream.read()));
/* 378 */         paramPrintStream.println("    Filter: " + HexDump.toHex((byte)paramInputStream.read()));
/* 379 */         paramPrintStream.println("    Data (after decompression): ");
/*     */         
/* 381 */         i -= 50;
/* 382 */         l -= 50L;
/*     */         
/* 384 */         short s = (i > (int)l) ? (short)(int)l : (short)i;
/*     */ 
/*     */         
/* 387 */         byte[] arrayOfByte = new byte[s];
/* 388 */         int j = paramInputStream.read(arrayOfByte);
/* 389 */         while (j != -1 && j < s)
/* 390 */           j += paramInputStream.read(arrayOfByte, j, arrayOfByte.length); 
/* 391 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*     */         
/* 393 */         InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
/* 394 */         byte b = -1;
/* 395 */         HexDump.dump(inflaterInputStream, paramPrintStream, 0, b);
/*     */         
/* 397 */         i -= s;
/* 398 */         l -= s;
/*     */       } 
/*     */ 
/*     */       
/* 402 */       boolean bool1 = ((s1 & 0xF) == 15) ? true : false;
/* 403 */       if (bool1 && l >= 0L) {
/*     */         
/* 405 */         if (i <= (int)l) {
/* 406 */           paramPrintStream.println("            completed within"); continue;
/*     */         } 
/* 408 */         paramPrintStream.println("            continued elsewhere"); continue;
/*     */       } 
/* 410 */       if (l >= 0L) {
/*     */ 
/*     */         
/* 413 */         short s = (i > (int)l) ? (short)(int)l : (short)i;
/*     */         
/* 415 */         if (s != 0) {
/*     */           
/* 417 */           HexDump.dump(paramInputStream, paramPrintStream, 0, s);
/* 418 */           l -= s;
/*     */         } 
/*     */         continue;
/*     */       } 
/* 422 */       paramPrintStream.println(" >> OVERRUN <<");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String propName(short paramShort) {
/*     */     final class PropName
/*     */     {
/*     */       final int _id;
/*     */ 
/*     */       
/*     */       final String _name;
/*     */ 
/*     */ 
/*     */       
/*     */       public PropName(int param1Int, String param1String) {
/* 439 */         this._id = param1Int;
/* 440 */         this._name = param1String;
/*     */       }
/*     */     };
/*     */     
/* 444 */     PropName[] arrayOfPropName = { new PropName(4, "transform.rotation"), new PropName(this, 119, "protection.lockrotation"), new PropName(this, 120, "protection.lockaspectratio"), new PropName(this, 121, "protection.lockposition"), new PropName(this, 122, "protection.lockagainstselect"), new PropName(this, 123, "protection.lockcropping"), new PropName(this, 124, "protection.lockvertices"), new PropName(this, 125, "protection.locktext"), new PropName(this, 126, "protection.lockadjusthandles"), new PropName(this, 127, "protection.lockagainstgrouping"), new PropName(this, 128, "text.textid"), new PropName(this, 129, "text.textleft"), new PropName(this, 130, "text.texttop"), new PropName(this, 131, "text.textright"), new PropName(this, 132, "text.textbottom"), new PropName(this, 133, "text.wraptext"), new PropName(this, 134, "text.scaletext"), new PropName(this, 135, "text.anchortext"), new PropName(this, 136, "text.textflow"), new PropName(this, 137, "text.fontrotation"), new PropName(this, 138, "text.idofnextshape"), new PropName(this, 139, "text.bidir"), new PropName(this, 187, "text.singleclickselects"), new PropName(this, 188, "text.usehostmargins"), new PropName(this, 189, "text.rotatetextwithshape"), new PropName(this, 190, "text.sizeshapetofittext"), new PropName(this, 191, "text.sizetexttofitshape"), new PropName(this, 192, "geotext.unicode"), new PropName(this, 193, "geotext.rtftext"), new PropName(this, 194, "geotext.alignmentoncurve"), new PropName(this, 195, "geotext.defaultpointsize"), new PropName(this, 196, "geotext.textspacing"), new PropName(this, 197, "geotext.fontfamilyname"), new PropName(this, 240, "geotext.reverseroworder"), new PropName(this, 241, "geotext.hastexteffect"), new PropName(this, 242, "geotext.rotatecharacters"), new PropName(this, 243, "geotext.kerncharacters"), new PropName(this, 244, "geotext.tightortrack"), new PropName(this, 245, "geotext.stretchtofitshape"), new PropName(this, 246, "geotext.charboundingbox"), new PropName(this, 247, "geotext.scaletextonpath"), new PropName(this, 248, "geotext.stretchcharheight"), new PropName(this, 249, "geotext.nomeasurealongpath"), new PropName(this, 250, "geotext.boldfont"), new PropName(this, 251, "geotext.italicfont"), new PropName(this, 252, "geotext.underlinefont"), new PropName(this, 253, "geotext.shadowfont"), new PropName(this, 254, "geotext.smallcapsfont"), new PropName(this, 255, "geotext.strikethroughfont"), new PropName(this, 256, "blip.cropfromtop"), new PropName(this, 257, "blip.cropfrombottom"), new PropName(this, 258, "blip.cropfromleft"), new PropName(this, 259, "blip.cropfromright"), new PropName(this, 260, "blip.bliptodisplay"), new PropName(this, 261, "blip.blipfilename"), new PropName(this, 262, "blip.blipflags"), new PropName(this, 263, "blip.transparentcolor"), new PropName(this, 264, "blip.contrastsetting"), new PropName(this, 265, "blip.brightnesssetting"), new PropName(this, 266, "blip.gamma"), new PropName(this, 267, "blip.pictureid"), new PropName(this, 268, "blip.doublemod"), new PropName(this, 269, "blip.picturefillmod"), new PropName(this, 270, "blip.pictureline"), new PropName(this, 271, "blip.printblip"), new PropName(this, 272, "blip.printblipfilename"), new PropName(this, 273, "blip.printflags"), new PropName(this, 316, "blip.nohittestpicture"), new PropName(this, 317, "blip.picturegray"), new PropName(this, 318, "blip.picturebilevel"), new PropName(this, 319, "blip.pictureactive"), new PropName(this, 320, "geometry.left"), new PropName(this, 321, "geometry.top"), new PropName(this, 322, "geometry.right"), new PropName(this, 323, "geometry.bottom"), new PropName(this, 324, "geometry.shapepath"), new PropName(this, 325, "geometry.vertices"), new PropName(this, 326, "geometry.segmentinfo"), new PropName(this, 327, "geometry.adjustvalue"), new PropName(this, 328, "geometry.adjust2value"), new PropName(this, 329, "geometry.adjust3value"), new PropName(this, 330, "geometry.adjust4value"), new PropName(this, 331, "geometry.adjust5value"), new PropName(this, 332, "geometry.adjust6value"), new PropName(this, 333, "geometry.adjust7value"), new PropName(this, 334, "geometry.adjust8value"), new PropName(this, 335, "geometry.adjust9value"), new PropName(this, 336, "geometry.adjust10value"), new PropName(this, 378, "geometry.shadowOK"), new PropName(this, 379, "geometry.3dok"), new PropName(this, 380, "geometry.lineok"), new PropName(this, 381, "geometry.geotextok"), new PropName(this, 382, "geometry.fillshadeshapeok"), new PropName(this, 383, "geometry.fillok"), new PropName(this, 384, "fill.filltype"), new PropName(this, 385, "fill.fillcolor"), new PropName(this, 386, "fill.fillopacity"), new PropName(this, 387, "fill.fillbackcolor"), new PropName(this, 388, "fill.backopacity"), new PropName(this, 389, "fill.crmod"), new PropName(this, 390, "fill.patterntexture"), new PropName(this, 391, "fill.blipfilename"), new PropName(this, 392, "fill.blipflags"), new PropName(this, 393, "fill.width"), new PropName(this, 394, "fill.height"), new PropName(this, 395, "fill.angle"), new PropName(this, 396, "fill.focus"), new PropName(this, 397, "fill.toleft"), new PropName(this, 398, "fill.totop"), new PropName(this, 399, "fill.toright"), new PropName(this, 400, "fill.tobottom"), new PropName(this, 401, "fill.rectleft"), new PropName(this, 402, "fill.recttop"), new PropName(this, 403, "fill.rectright"), new PropName(this, 404, "fill.rectbottom"), new PropName(this, 405, "fill.dztype"), new PropName(this, 406, "fill.shadepreset"), new PropName(this, 407, "fill.shadecolors"), new PropName(this, 408, "fill.originx"), new PropName(this, 409, "fill.originy"), new PropName(this, 410, "fill.shapeoriginx"), new PropName(this, 411, "fill.shapeoriginy"), new PropName(this, 412, "fill.shadetype"), new PropName(this, 443, "fill.filled"), new PropName(this, 444, "fill.hittestfill"), new PropName(this, 445, "fill.shape"), new PropName(this, 446, "fill.userect"), new PropName(this, 447, "fill.nofillhittest"), new PropName(this, 448, "linestyle.color"), new PropName(this, 449, "linestyle.opacity"), new PropName(this, 450, "linestyle.backcolor"), new PropName(this, 451, "linestyle.crmod"), new PropName(this, 452, "linestyle.linetype"), new PropName(this, 453, "linestyle.fillblip"), new PropName(this, 454, "linestyle.fillblipname"), new PropName(this, 455, "linestyle.fillblipflags"), new PropName(this, 456, "linestyle.fillwidth"), new PropName(this, 457, "linestyle.fillheight"), new PropName(this, 458, "linestyle.filldztype"), new PropName(this, 459, "linestyle.linewidth"), new PropName(this, 460, "linestyle.linemiterlimit"), new PropName(this, 461, "linestyle.linestyle"), new PropName(this, 462, "linestyle.linedashing"), new PropName(this, 463, "linestyle.linedashstyle"), new PropName(this, 464, "linestyle.linestartarrowhead"), new PropName(this, 465, "linestyle.lineendarrowhead"), new PropName(this, 466, "linestyle.linestartarrowwidth"), new PropName(this, 467, "linestyle.lineestartarrowlength"), new PropName(this, 468, "linestyle.lineendarrowwidth"), new PropName(this, 469, "linestyle.lineendarrowlength"), new PropName(this, 470, "linestyle.linejoinstyle"), new PropName(this, 471, "linestyle.lineendcapstyle"), new PropName(this, 507, "linestyle.arrowheadsok"), new PropName(this, 508, "linestyle.anyline"), new PropName(this, 509, "linestyle.hitlinetest"), new PropName(this, 510, "linestyle.linefillshape"), new PropName(this, 511, "linestyle.nolinedrawdash"), new PropName(this, 512, "shadowstyle.type"), new PropName(this, 513, "shadowstyle.color"), new PropName(this, 514, "shadowstyle.highlight"), new PropName(this, 515, "shadowstyle.crmod"), new PropName(this, 516, "shadowstyle.opacity"), new PropName(this, 517, "shadowstyle.offsetx"), new PropName(this, 518, "shadowstyle.offsety"), new PropName(this, 519, "shadowstyle.secondoffsetx"), new PropName(this, 520, "shadowstyle.secondoffsety"), new PropName(this, 521, "shadowstyle.scalextox"), new PropName(this, 522, "shadowstyle.scaleytox"), new PropName(this, 523, "shadowstyle.scalextoy"), new PropName(this, 524, "shadowstyle.scaleytoy"), new PropName(this, 525, "shadowstyle.perspectivex"), new PropName(this, 526, "shadowstyle.perspectivey"), new PropName(this, 527, "shadowstyle.weight"), new PropName(this, 528, "shadowstyle.originx"), new PropName(this, 529, "shadowstyle.originy"), new PropName(this, 574, "shadowstyle.shadow"), new PropName(this, 575, "shadowstyle.shadowobsured"), new PropName(this, 576, "perspective.type"), new PropName(this, 577, "perspective.offsetx"), new PropName(this, 578, "perspective.offsety"), new PropName(this, 579, "perspective.scalextox"), new PropName(this, 580, "perspective.scaleytox"), new PropName(this, 581, "perspective.scalextoy"), new PropName(this, 582, "perspective.scaleytox"), new PropName(this, 583, "perspective.perspectivex"), new PropName(this, 584, "perspective.perspectivey"), new PropName(this, 585, "perspective.weight"), new PropName(this, 586, "perspective.originx"), new PropName(this, 587, "perspective.originy"), new PropName(this, 639, "perspective.perspectiveon"), new PropName(this, 640, "3d.specularamount"), new PropName(this, 661, "3d.diffuseamount"), new PropName(this, 662, "3d.shininess"), new PropName(this, 663, "3d.edgethickness"), new PropName(this, 664, "3d.extrudeforward"), new PropName(this, 665, "3d.extrudebackward"), new PropName(this, 666, "3d.extrudeplane"), new PropName(this, 667, "3d.extrusioncolor"), new PropName(this, 648, "3d.crmod"), new PropName(this, 700, "3d.3deffect"), new PropName(this, 701, "3d.metallic"), new PropName(this, 702, "3d.useextrusioncolor"), new PropName(this, 703, "3d.lightface"), new PropName(this, 704, "3dstyle.yrotationangle"), new PropName(this, 705, "3dstyle.xrotationangle"), new PropName(this, 706, "3dstyle.rotationaxisx"), new PropName(this, 707, "3dstyle.rotationaxisy"), new PropName(this, 708, "3dstyle.rotationaxisz"), new PropName(this, 709, "3dstyle.rotationangle"), new PropName(this, 710, "3dstyle.rotationcenterx"), new PropName(this, 711, "3dstyle.rotationcentery"), new PropName(this, 712, "3dstyle.rotationcenterz"), new PropName(this, 713, "3dstyle.rendermode"), new PropName(this, 714, "3dstyle.tolerance"), new PropName(this, 715, "3dstyle.xviewpoint"), new PropName(this, 716, "3dstyle.yviewpoint"), new PropName(this, 717, "3dstyle.zviewpoint"), new PropName(this, 718, "3dstyle.originx"), new PropName(this, 719, "3dstyle.originy"), new PropName(this, 720, "3dstyle.skewangle"), new PropName(this, 721, "3dstyle.skewamount"), new PropName(this, 722, "3dstyle.ambientintensity"), new PropName(this, 723, "3dstyle.keyx"), new PropName(this, 724, "3dstyle.keyy"), new PropName(this, 725, "3dstyle.keyz"), new PropName(this, 726, "3dstyle.keyintensity"), new PropName(this, 727, "3dstyle.fillx"), new PropName(this, 728, "3dstyle.filly"), new PropName(this, 729, "3dstyle.fillz"), new PropName(this, 730, "3dstyle.fillintensity"), new PropName(this, 763, "3dstyle.constrainrotation"), new PropName(this, 764, "3dstyle.rotationcenterauto"), new PropName(this, 765, "3dstyle.parallel"), new PropName(this, 766, "3dstyle.keyharsh"), new PropName(this, 767, "3dstyle.fillharsh"), new PropName(this, 769, "shape.master"), new PropName(this, 771, "shape.connectorstyle"), new PropName(this, 772, "shape.blackandwhitesettings"), new PropName(this, 773, "shape.wmodepurebw"), new PropName(this, 774, "shape.wmodebw"), new PropName(this, 826, "shape.oleicon"), new PropName(this, 827, "shape.preferrelativeresize"), new PropName(this, 828, "shape.lockshapetype"), new PropName(this, 830, "shape.deleteattachedobject"), new PropName(this, 831, "shape.backgroundshape"), new PropName(this, 832, "callout.callouttype"), new PropName(this, 833, "callout.xycalloutgap"), new PropName(this, 834, "callout.calloutangle"), new PropName(this, 835, "callout.calloutdroptype"), new PropName(this, 836, "callout.calloutdropspecified"), new PropName(this, 837, "callout.calloutlengthspecified"), new PropName(this, 889, "callout.iscallout"), new PropName(this, 890, "callout.calloutaccentbar"), new PropName(this, 891, "callout.callouttextborder"), new PropName(this, 892, "callout.calloutminusx"), new PropName(this, 893, "callout.calloutminusy"), new PropName(this, 894, "callout.dropauto"), new PropName(this, 895, "callout.lengthspecified"), new PropName(this, 896, "groupshape.shapename"), new PropName(this, 897, "groupshape.description"), new PropName(this, 898, "groupshape.hyperlink"), new PropName(this, 899, "groupshape.wrappolygonvertices"), new PropName(this, 900, "groupshape.wrapdistleft"), new PropName(this, 901, "groupshape.wrapdisttop"), new PropName(this, 902, "groupshape.wrapdistright"), new PropName(this, 903, "groupshape.wrapdistbottom"), new PropName(this, 904, "groupshape.regroupid"), new PropName(this, 953, "groupshape.editedwrap"), new PropName(this, 954, "groupshape.behinddocument"), new PropName(this, 955, "groupshape.ondblclicknotify"), new PropName(this, 956, "groupshape.isbutton"), new PropName(this, 957, "groupshape.1dadjustment"), new PropName(this, 958, "groupshape.hidden"), new PropName(this, 959, "groupshape.print") };
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
/* 721 */     for (byte b = 0; b < arrayOfPropName.length; b++) {
/* 722 */       if ((arrayOfPropName[b])._id == paramShort) {
/* 723 */         return (arrayOfPropName[b])._name;
/*     */       }
/*     */     } 
/*     */     
/* 727 */     return "unknown property";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getBlipType(byte paramByte) {
/* 737 */     return EscherBSERecord.getBlipType(paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String dec1616(int paramInt) {
/* 745 */     String str = "";
/* 746 */     str = str + (short)(paramInt >> 16);
/* 747 */     str = str + '.';
/* 748 */     str = str + (short)(paramInt & 0xFFFF);
/* 749 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void outHex(int paramInt, InputStream paramInputStream, PrintStream paramPrintStream) throws IOException, LittleEndian.BufferUnderrunException {
/* 761 */     switch (paramInt) {
/*     */       
/*     */       case 1:
/* 764 */         paramPrintStream.print(HexDump.toHex((byte)paramInputStream.read()));
/*     */         return;
/*     */       case 2:
/* 767 */         paramPrintStream.print(HexDump.toHex(LittleEndian.readShort(paramInputStream)));
/*     */         return;
/*     */       case 4:
/* 770 */         paramPrintStream.print(HexDump.toHex(LittleEndian.readInt(paramInputStream)));
/*     */         return;
/*     */     } 
/* 773 */     throw new IOException("Unable to output variable of that width");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 783 */     main(paramArrayOfString, System.out);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString, PrintStream paramPrintStream) {
/* 787 */     String str = "0F 00 00 F0 89 07 00 00 00 00 06 F0 18 00 00 00 05 04 00 00 02 00 00 00 05 00 00 00 01 00 00 00 01 00 00 00 05 00 00 00 4F 00 01 F0 2F 07 00 00 42 00 07 F0 B7 01 00 00 03 04 3F 14 AE 6B 0F 65 B0 48 BF 5E 94 63 80 E8 91 73 FF 00 93 01 00 00 01 00 00 00 00 00 00 00 00 00 FF FF 20 54 1C F0 8B 01 00 00 3F 14 AE 6B 0F 65 B0 48 BF 5E 94 63 80 E8 91 73 92 0E 00 00 00 00 00 00 00 00 00 00 D1 07 00 00 DD 05 00 00 4A AD 6F 00 8A C5 53 00 59 01 00 00 00 FE 78 9C E3 9B C4 00 04 AC 77 D9 2F 32 08 32 FD E7 61 F8 FF 0F C8 FD 05 C5 30 19 10 90 63 90 FA 0F 06 0C 8C 0C 5C 70 19 43 30 EB 0E FB 05 86 85 0C DB 18 58 80 72 8C 70 16 0B 83 05 56 51 29 88 C9 60 D9 69 0C 6C 20 26 23 03 C8 74 B0 A8 0E 03 07 FB 45 56 C7 A2 CC C4 1C 06 66 A0 0D 2C 40 39 5E 86 4C 06 3D A0 4E 10 D0 60 D9 C8 58 CC E8 CF B0 80 61 3A 8A 7E 0D C6 23 AC 4F E0 E2 98 B6 12 2B 06 73 9D 12 E3 52 56 59 F6 08 8A CC 52 66 A3 50 FF 96 2B 94 E9 DF 4C A1 FE 2D 3A 03 AB 9F 81 C2 F0 A3 54 BF 0F 85 EE A7 54 FF 40 FB 7F A0 E3 9F D2 F4 4F 71 FE 19 58 FF 2B 31 7F 67 36 3B 25 4F 99 1B 4E 53 A6 5F 89 25 95 E9 C4 00 C7 83 12 F3 1F 26 35 4A D3 D2 47 0E 0A C3 41 8E C9 8A 52 37 DC 15 A1 D0 0D BC 4C 06 0C 2B 28 2C 13 28 D4 EF 43 61 5A A0 58 3F 85 71 E0 4B 69 9E 64 65 FE 39 C0 E5 22 30 1D 30 27 0E 74 3A 18 60 FD 4A CC B1 2C 13 7D 07 36 2D 2A 31 85 B2 6A 0D 74 1D 1D 22 4D 99 FE 60 0A F5 9B EC 1C 58 FD 67 06 56 3F 38 0D 84 3C A5 30 0E 28 D3 AF C4 A4 CA FA 44 7A 0D 65 6E 60 7F 4D A1 1B 24 58 F7 49 AF A5 CC 0D CC DF 19 FE 03 00 F0 B1 25 4D 42 00 07 F0 E1 01 00 00 03 04 39 50 BE 98 B0 6F 57 24 31 70 5D 23 2F 9F 10 66 FF 00 BD 01 00 00 01 00 00 00 00 00 00 00 00 00 FF FF 20 54 1C F0 B5 01 00 00 39 50 BE 98 B0 6F 57 24 31 70 5D 23 2F 9F 10 66 DA 03 00 00 00 00 00 00 00 00 00 00 D1 07 00 00 DD 05 00 00 4A AD 6F 00 8A C5 53 00 83 01 00 00 00 FE 78 9C A5 52 BF 4B 42 51 14 3E F7 DC 77 7A 16 45 48 8B 3C 48 A8 16 15 0D 6C 88 D0 04 C3 40 A3 32 1C 84 96 08 21 04 A1 C5 5C A2 35 82 C0 35 6A AB 1C 6A 6B A8 24 5A 83 68 08 84 84 96 A2 86 A0 7F C2 86 5E E7 5E F5 41 E4 10 BC 03 1F E7 FB F1 CE B9 F7 F1 9E 7C 05 2E 7A 37 9B E0 45 7B 10 EC 6F 96 5F 1D 74 13 55 7E B0 6C 5D 20 60 C0 49 A2 9A BD 99 4F 50 83 1B 30 38 13 0E 33 60 A6 A7 6B B5 37 EB F4 10 FA 14 15 A0 B6 6B 37 0C 1E B3 49 73 5B A5 C2 26 48 3E C1 E0 6C 08 4A 30 C9 93 AA 02 B8 20 13 62 05 4E E1 E8 D7 7C C0 B8 14 95 5E BE B8 A7 CF 1E BE 55 2C 56 B9 78 DF 08 7E 88 4C 27 FF 7B DB FF 7A DD B7 1A 17 67 34 6A AE BA DA 35 D1 E7 72 BE FE EC 6E FE DA E5 7C 3D EC 7A DE 03 FD 50 06 0B 23 F2 0E F3 B2 A5 11 91 0D 4C B5 B5 F3 BF 94 C1 8F 24 F7 D9 6F 60 94 3B C9 9A F3 1C 6B E7 BB F0 2E 49 B2 25 2B C6 B1 EE 69 EE 15 63 4F 71 7D CE 85 CC C8 35 B9 C3 28 28 CE D0 5C 67 79 F2 4A A2 14 23 A4 38 43 73 9D 2D 69 2F C1 08 31 9F C5 5C 9B EB 7B C5 69 19 B3 B4 81 F3 DC E3 B4 8E 8B CC B3 94 53 5A E7 41 2A 63 9A AA 38 C5 3D 48 BB EC 57 59 6F 2B AD 73 1F 1D 60 92 AE 70 8C BB 8F CE 31 C1 3C 49 27 4A EB DC A4 5B 8C D1 0B 0E 73 37 E9 11 A7 99 C7 E8 41 69 B0 7F 00 96 F2 A7 E8 42 00 07 F0 B4 01 00 00 03 04 1A BA F9 D6 A9 B9 3A 03 08 61 E9 90 FF 7B 9E E6 FF 00 90 01 00 00 01 00 00 00 00 00 00 00 00 00 FF FF 20 54 1C F0 88 01 00 00 1A BA F9 D6 A9 B9 3A 03 08 61 E9 90 FF 7B 9E E6 12 0E 00 00 00 00 00 00 00 00 00 00 D1 07 00 00 DD 05 00 00 4A AD 6F 00 8A C5 53 00 56 01 00 00 00 FE 78 9C E3 13 62 00 02 D6 BB EC 17 19 04 99 FE F3 30 FC FF 07 E4 FE 82 62 98 0C 08 C8 31 48 FD 07 03 06 46 06 2E B8 8C 21 98 75 87 FD 02 C3 42 86 6D 0C 2C 40 39 46 38 8B 85 C1 02 AB A8 14 C4 64 B0 EC 34 06 36 10 93 91 01 64 3A 58 54 87 81 83 FD 22 AB 63 51 66 62 0E 03 33 D0 06 16 A0 1C 2F 43 26 83 1E 50 27 08 68 B0 6C 64 2C 66 F4 67 58 C0 30 1D 45 BF 06 E3 11 D6 27 70 71 4C 5B 89 15 83 B9 4E 89 71 29 AB 2C 7B 04 45 66 29 B3 51 A8 7F CB 15 CA F4 6F A6 50 FF 16 9D 81 D5 CF 40 61 F8 51 AA DF 87 42 F7 53 AA 7F A0 FD 3F D0 F1 4F 69 FA A7 38 FF 0C AC FF 95 98 BF 33 9B 9D 92 A7 CC 0D A7 29 D3 AF C4 92 CA 74 62 80 E3 41 89 F9 0F 93 1A A5 69 E9 23 07 85 E1 20 C7 64 45 A9 1B EE 8A 50 E8 06 5E 26 03 86 15 14 96 09 14 EA F7 A1 30 2D 50 AC 9F C2 38 F0 A5 34 4F B2 32 FF 1C E0 72 11 98 0E 98 13 07 38 1D 28 31 C7 B2 4C F4 1D D8 B4 A0 C4 14 CA AA 35 D0 75 64 88 34 65 FA 83 29 D4 6F B2 73 60 F5 9F A1 54 FF 0E CA D3 40 C8 53 0A E3 E0 09 85 6E 50 65 7D 22 BD 86 32 37 B0 BF A6 D0 0D 12 AC FB A4 D7 52 E6 06 E6 EF 0C FF 01 97 1D 12 C7 42 00 07 F0 C3 01 00 00 03 04 BA 4C B6 23 BA 8B 27 BE C8 55 59 86 24 9F 89 D4 FF 00 9F 01 00 00 01 00 00 00 00 00 00 00 00 00 FF FF 20 54 1C F0 97 01 00 00 BA 4C B6 23 BA 8B 27 BE C8 55 59 86 24 9F 89 D4 AE 0E 00 00 00 00 00 00 00 00 00 00 D1 07 00 00 DD 05 00 00 4A AD 6F 00 8A C5 53 00 65 01 00 00 00 FE 78 9C E3 5B C7 00 04 AC 77 D9 2F 32 08 32 FD E7 61 F8 FF 0F C8 FD 05 C5 30 19 10 90 63 90 FA 0F 06 0C 8C 0C 5C 70 19 43 30 EB 0E FB 05 86 85 0C DB 18 58 80 72 8C 70 16 0B 83 05 56 51 29 88 C9 60 D9 69 0C 6C 20 26 23 03 C8 74 B0 A8 0E 03 07 FB 45 56 C7 A2 CC C4 1C 06 66 A0 0D 2C 40 39 5E 86 4C 06 3D A0 4E 10 D0 60 99 C6 B8 98 D1 9F 61 01 C3 74 14 FD 1A 8C 2B D8 84 B1 88 4B A5 A5 75 03 01 50 DF 59 46 77 46 0F A8 3C A6 AB 88 15 83 B9 5E 89 B1 8B D5 97 2D 82 22 B3 94 29 D5 BF E5 CA C0 EA DF AC 43 A1 FD 14 EA 67 A0 30 FC 28 D5 EF 43 A1 FB 7D 87 B8 FF 07 3A FE 07 3A FD 53 EA 7E 0A C3 4F 89 F9 0E 73 EA 69 79 CA DC 70 8A 32 FD 4A 2C 5E 4C DF 87 7A 3C BC E0 A5 30 1E 3E 31 C5 33 AC A0 30 2F 52 A8 DF 87 C2 30 A4 54 3F A5 65 19 85 65 A9 12 D3 2B 16 0D 8A CB 13 4A F3 E3 27 E6 09 03 9D 0E 06 58 BF 12 B3 13 CB C1 01 4E 8B 4A 4C 56 AC 91 03 5D 37 86 48 53 A6 3F 98 42 FD 26 3B 07 56 FF 99 1D 14 EA A7 CC 7E 70 1A 08 79 42 61 1C 3C A5 D0 0D 9C 6C C2 32 6B 29 73 03 DB 6B CA DC C0 F8 97 F5 AD CC 1A CA DC C0 F4 83 32 37 B0 A4 30 CE FC C7 48 99 1B FE 33 32 FC 07 00 6C CC 2E 23 33 00 0B F0 12 00 00 00 BF 00 08 00 08 00 81 01 09 00 00 08 C0 01 40 00 00 08 40 00 1E F1 10 00 00 00 0D 00 00 08 0C 00 00 08 17 00 00 08 F7 00 00 10                                              ";
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
/* 912 */     byte[] arrayOfByte = HexRead.readFromString(str);
/*     */     
/* 914 */     EscherDump escherDump = new EscherDump();
/*     */ 
/*     */     
/* 917 */     escherDump.dump(arrayOfByte, 0, arrayOfByte.length, paramPrintStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dump(int paramInt, byte[] paramArrayOfbyte, PrintStream paramPrintStream) {
/* 922 */     dump(paramArrayOfbyte, 0, paramInt, paramPrintStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */