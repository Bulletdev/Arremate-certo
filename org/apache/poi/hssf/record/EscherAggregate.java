/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherDgRecord;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherSerializationListener;
/*     */ import org.apache.poi.ddf.EscherSpRecord;
/*     */ import org.apache.poi.ddf.EscherSpgrRecord;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EscherAggregate
/*     */   extends AbstractEscherHolderRecord
/*     */ {
/*     */   public static final short sid = 9876;
/*  86 */   private static POILogger log = POILogFactory.getLogger(EscherAggregate.class);
/*     */   
/*     */   public static final short ST_MIN = 0;
/*     */   
/*     */   public static final short ST_NOT_PRIMATIVE = 0;
/*     */   
/*     */   public static final short ST_RECTANGLE = 1;
/*     */   
/*     */   public static final short ST_ROUNDRECTANGLE = 2;
/*     */   
/*     */   public static final short ST_ELLIPSE = 3;
/*     */   public static final short ST_DIAMOND = 4;
/*     */   public static final short ST_ISOCELESTRIANGLE = 5;
/*     */   public static final short ST_RIGHTTRIANGLE = 6;
/*     */   public static final short ST_PARALLELOGRAM = 7;
/*     */   public static final short ST_TRAPEZOID = 8;
/*     */   public static final short ST_HEXAGON = 9;
/*     */   public static final short ST_OCTAGON = 10;
/*     */   public static final short ST_PLUS = 11;
/*     */   public static final short ST_STAR = 12;
/*     */   public static final short ST_ARROW = 13;
/*     */   public static final short ST_THICKARROW = 14;
/*     */   public static final short ST_HOMEPLATE = 15;
/*     */   public static final short ST_CUBE = 16;
/*     */   public static final short ST_BALLOON = 17;
/*     */   public static final short ST_SEAL = 18;
/*     */   public static final short ST_ARC = 19;
/*     */   public static final short ST_LINE = 20;
/*     */   public static final short ST_PLAQUE = 21;
/*     */   public static final short ST_CAN = 22;
/*     */   public static final short ST_DONUT = 23;
/*     */   public static final short ST_TEXTSIMPLE = 24;
/*     */   public static final short ST_TEXTOCTAGON = 25;
/*     */   public static final short ST_TEXTHEXAGON = 26;
/*     */   public static final short ST_TEXTCURVE = 27;
/*     */   public static final short ST_TEXTWAVE = 28;
/*     */   public static final short ST_TEXTRING = 29;
/*     */   public static final short ST_TEXTONCURVE = 30;
/*     */   public static final short ST_TEXTONRING = 31;
/*     */   public static final short ST_STRAIGHTCONNECTOR1 = 32;
/*     */   public static final short ST_BENTCONNECTOR2 = 33;
/*     */   public static final short ST_BENTCONNECTOR3 = 34;
/*     */   public static final short ST_BENTCONNECTOR4 = 35;
/*     */   public static final short ST_BENTCONNECTOR5 = 36;
/*     */   public static final short ST_CURVEDCONNECTOR2 = 37;
/*     */   public static final short ST_CURVEDCONNECTOR3 = 38;
/*     */   public static final short ST_CURVEDCONNECTOR4 = 39;
/*     */   public static final short ST_CURVEDCONNECTOR5 = 40;
/*     */   public static final short ST_CALLOUT1 = 41;
/*     */   public static final short ST_CALLOUT2 = 42;
/*     */   public static final short ST_CALLOUT3 = 43;
/*     */   public static final short ST_ACCENTCALLOUT1 = 44;
/*     */   public static final short ST_ACCENTCALLOUT2 = 45;
/*     */   public static final short ST_ACCENTCALLOUT3 = 46;
/*     */   public static final short ST_BORDERCALLOUT1 = 47;
/*     */   public static final short ST_BORDERCALLOUT2 = 48;
/*     */   public static final short ST_BORDERCALLOUT3 = 49;
/*     */   public static final short ST_ACCENTBORDERCALLOUT1 = 50;
/*     */   public static final short ST_ACCENTBORDERCALLOUT2 = 51;
/*     */   public static final short ST_ACCENTBORDERCALLOUT3 = 52;
/*     */   public static final short ST_RIBBON = 53;
/*     */   public static final short ST_RIBBON2 = 54;
/*     */   public static final short ST_CHEVRON = 55;
/*     */   public static final short ST_PENTAGON = 56;
/*     */   public static final short ST_NOSMOKING = 57;
/*     */   public static final short ST_SEAL8 = 58;
/*     */   public static final short ST_SEAL16 = 59;
/*     */   public static final short ST_SEAL32 = 60;
/*     */   public static final short ST_WEDGERECTCALLOUT = 61;
/*     */   public static final short ST_WEDGERRECTCALLOUT = 62;
/*     */   public static final short ST_WEDGEELLIPSECALLOUT = 63;
/*     */   public static final short ST_WAVE = 64;
/*     */   public static final short ST_FOLDEDCORNER = 65;
/*     */   public static final short ST_LEFTARROW = 66;
/*     */   public static final short ST_DOWNARROW = 67;
/*     */   public static final short ST_UPARROW = 68;
/*     */   public static final short ST_LEFTRIGHTARROW = 69;
/*     */   public static final short ST_UPDOWNARROW = 70;
/*     */   public static final short ST_IRREGULARSEAL1 = 71;
/*     */   public static final short ST_IRREGULARSEAL2 = 72;
/*     */   public static final short ST_LIGHTNINGBOLT = 73;
/*     */   public static final short ST_HEART = 74;
/*     */   public static final short ST_PICTUREFRAME = 75;
/*     */   public static final short ST_QUADARROW = 76;
/*     */   public static final short ST_LEFTARROWCALLOUT = 77;
/*     */   public static final short ST_RIGHTARROWCALLOUT = 78;
/*     */   public static final short ST_UPARROWCALLOUT = 79;
/*     */   public static final short ST_DOWNARROWCALLOUT = 80;
/*     */   public static final short ST_LEFTRIGHTARROWCALLOUT = 81;
/*     */   public static final short ST_UPDOWNARROWCALLOUT = 82;
/*     */   public static final short ST_QUADARROWCALLOUT = 83;
/*     */   public static final short ST_BEVEL = 84;
/*     */   public static final short ST_LEFTBRACKET = 85;
/*     */   public static final short ST_RIGHTBRACKET = 86;
/*     */   public static final short ST_LEFTBRACE = 87;
/*     */   public static final short ST_RIGHTBRACE = 88;
/*     */   public static final short ST_LEFTUPARROW = 89;
/*     */   public static final short ST_BENTUPARROW = 90;
/*     */   public static final short ST_BENTARROW = 91;
/*     */   public static final short ST_SEAL24 = 92;
/*     */   public static final short ST_STRIPEDRIGHTARROW = 93;
/*     */   public static final short ST_NOTCHEDRIGHTARROW = 94;
/*     */   public static final short ST_BLOCKARC = 95;
/*     */   public static final short ST_SMILEYFACE = 96;
/*     */   public static final short ST_VERTICALSCROLL = 97;
/*     */   public static final short ST_HORIZONTALSCROLL = 98;
/*     */   public static final short ST_CIRCULARARROW = 99;
/*     */   public static final short ST_NOTCHEDCIRCULARARROW = 100;
/*     */   public static final short ST_UTURNARROW = 101;
/*     */   public static final short ST_CURVEDRIGHTARROW = 102;
/*     */   public static final short ST_CURVEDLEFTARROW = 103;
/*     */   public static final short ST_CURVEDUPARROW = 104;
/*     */   public static final short ST_CURVEDDOWNARROW = 105;
/*     */   public static final short ST_CLOUDCALLOUT = 106;
/*     */   public static final short ST_ELLIPSERIBBON = 107;
/*     */   public static final short ST_ELLIPSERIBBON2 = 108;
/*     */   public static final short ST_FLOWCHARTPROCESS = 109;
/*     */   public static final short ST_FLOWCHARTDECISION = 110;
/*     */   public static final short ST_FLOWCHARTINPUTOUTPUT = 111;
/*     */   public static final short ST_FLOWCHARTPREDEFINEDPROCESS = 112;
/*     */   public static final short ST_FLOWCHARTINTERNALSTORAGE = 113;
/*     */   public static final short ST_FLOWCHARTDOCUMENT = 114;
/*     */   public static final short ST_FLOWCHARTMULTIDOCUMENT = 115;
/*     */   public static final short ST_FLOWCHARTTERMINATOR = 116;
/*     */   public static final short ST_FLOWCHARTPREPARATION = 117;
/*     */   public static final short ST_FLOWCHARTMANUALINPUT = 118;
/*     */   public static final short ST_FLOWCHARTMANUALOPERATION = 119;
/*     */   public static final short ST_FLOWCHARTCONNECTOR = 120;
/*     */   public static final short ST_FLOWCHARTPUNCHEDCARD = 121;
/*     */   public static final short ST_FLOWCHARTPUNCHEDTAPE = 122;
/*     */   public static final short ST_FLOWCHARTSUMMINGJUNCTION = 123;
/*     */   public static final short ST_FLOWCHARTOR = 124;
/*     */   public static final short ST_FLOWCHARTCOLLATE = 125;
/*     */   public static final short ST_FLOWCHARTSORT = 126;
/*     */   public static final short ST_FLOWCHARTEXTRACT = 127;
/*     */   public static final short ST_FLOWCHARTMERGE = 128;
/*     */   public static final short ST_FLOWCHARTOFFLINESTORAGE = 129;
/*     */   public static final short ST_FLOWCHARTONLINESTORAGE = 130;
/*     */   public static final short ST_FLOWCHARTMAGNETICTAPE = 131;
/*     */   public static final short ST_FLOWCHARTMAGNETICDISK = 132;
/*     */   public static final short ST_FLOWCHARTMAGNETICDRUM = 133;
/*     */   public static final short ST_FLOWCHARTDISPLAY = 134;
/*     */   public static final short ST_FLOWCHARTDELAY = 135;
/*     */   public static final short ST_TEXTPLAINTEXT = 136;
/*     */   public static final short ST_TEXTSTOP = 137;
/*     */   public static final short ST_TEXTTRIANGLE = 138;
/*     */   public static final short ST_TEXTTRIANGLEINVERTED = 139;
/*     */   public static final short ST_TEXTCHEVRON = 140;
/*     */   public static final short ST_TEXTCHEVRONINVERTED = 141;
/*     */   public static final short ST_TEXTRINGINSIDE = 142;
/*     */   public static final short ST_TEXTRINGOUTSIDE = 143;
/*     */   public static final short ST_TEXTARCHUPCURVE = 144;
/*     */   public static final short ST_TEXTARCHDOWNCURVE = 145;
/*     */   public static final short ST_TEXTCIRCLECURVE = 146;
/*     */   public static final short ST_TEXTBUTTONCURVE = 147;
/*     */   public static final short ST_TEXTARCHUPPOUR = 148;
/*     */   public static final short ST_TEXTARCHDOWNPOUR = 149;
/*     */   public static final short ST_TEXTCIRCLEPOUR = 150;
/*     */   public static final short ST_TEXTBUTTONPOUR = 151;
/*     */   public static final short ST_TEXTCURVEUP = 152;
/*     */   public static final short ST_TEXTCURVEDOWN = 153;
/*     */   public static final short ST_TEXTCASCADEUP = 154;
/*     */   public static final short ST_TEXTCASCADEDOWN = 155;
/*     */   public static final short ST_TEXTWAVE1 = 156;
/*     */   public static final short ST_TEXTWAVE2 = 157;
/*     */   public static final short ST_TEXTWAVE3 = 158;
/*     */   public static final short ST_TEXTWAVE4 = 159;
/*     */   public static final short ST_TEXTINFLATE = 160;
/*     */   public static final short ST_TEXTDEFLATE = 161;
/*     */   public static final short ST_TEXTINFLATEBOTTOM = 162;
/*     */   public static final short ST_TEXTDEFLATEBOTTOM = 163;
/*     */   public static final short ST_TEXTINFLATETOP = 164;
/*     */   public static final short ST_TEXTDEFLATETOP = 165;
/*     */   public static final short ST_TEXTDEFLATEINFLATE = 166;
/*     */   public static final short ST_TEXTDEFLATEINFLATEDEFLATE = 167;
/*     */   public static final short ST_TEXTFADERIGHT = 168;
/*     */   public static final short ST_TEXTFADELEFT = 169;
/*     */   public static final short ST_TEXTFADEUP = 170;
/*     */   public static final short ST_TEXTFADEDOWN = 171;
/*     */   public static final short ST_TEXTSLANTUP = 172;
/*     */   public static final short ST_TEXTSLANTDOWN = 173;
/*     */   public static final short ST_TEXTCANUP = 174;
/*     */   public static final short ST_TEXTCANDOWN = 175;
/*     */   public static final short ST_FLOWCHARTALTERNATEPROCESS = 176;
/*     */   public static final short ST_FLOWCHARTOFFPAGECONNECTOR = 177;
/*     */   public static final short ST_CALLOUT90 = 178;
/*     */   public static final short ST_ACCENTCALLOUT90 = 179;
/*     */   public static final short ST_BORDERCALLOUT90 = 180;
/*     */   public static final short ST_ACCENTBORDERCALLOUT90 = 181;
/*     */   public static final short ST_LEFTRIGHTUPARROW = 182;
/*     */   public static final short ST_SUN = 183;
/*     */   public static final short ST_MOON = 184;
/*     */   public static final short ST_BRACKETPAIR = 185;
/*     */   public static final short ST_BRACEPAIR = 186;
/*     */   public static final short ST_SEAL4 = 187;
/*     */   public static final short ST_DOUBLEWAVE = 188;
/*     */   public static final short ST_ACTIONBUTTONBLANK = 189;
/*     */   public static final short ST_ACTIONBUTTONHOME = 190;
/*     */   public static final short ST_ACTIONBUTTONHELP = 191;
/*     */   public static final short ST_ACTIONBUTTONINFORMATION = 192;
/*     */   public static final short ST_ACTIONBUTTONFORWARDNEXT = 193;
/*     */   public static final short ST_ACTIONBUTTONBACKPREVIOUS = 194;
/*     */   public static final short ST_ACTIONBUTTONEND = 195;
/*     */   public static final short ST_ACTIONBUTTONBEGINNING = 196;
/*     */   public static final short ST_ACTIONBUTTONRETURN = 197;
/*     */   public static final short ST_ACTIONBUTTONDOCUMENT = 198;
/*     */   public static final short ST_ACTIONBUTTONSOUND = 199;
/*     */   public static final short ST_ACTIONBUTTONMOVIE = 200;
/*     */   public static final short ST_HOSTCONTROL = 201;
/*     */   public static final short ST_TEXTBOX = 202;
/*     */   public static final short ST_NIL = 4095;
/* 297 */   private final Map<EscherRecord, Record> shapeToObj = new HashMap<EscherRecord, Record>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 302 */   private final Map<Integer, NoteRecord> tailRec = new LinkedHashMap<Integer, NoteRecord>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherAggregate(boolean paramBoolean) {
/* 310 */     if (paramBoolean) {
/* 311 */       buildBaseTree();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 319 */     return 9876;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 327 */     String str = System.getProperty("line.separtor");
/*     */     
/* 329 */     StringBuilder stringBuilder = new StringBuilder();
/* 330 */     stringBuilder.append('[').append(getRecordName()).append(']').append(str);
/* 331 */     for (EscherRecord escherRecord : getEscherRecords()) {
/* 332 */       stringBuilder.append(escherRecord.toString());
/*     */     }
/* 334 */     stringBuilder.append("[/").append(getRecordName()).append(']').append(str);
/*     */     
/* 336 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 346 */     StringBuilder stringBuilder = new StringBuilder();
/* 347 */     stringBuilder.append(paramString).append("<").append(getRecordName()).append(">\n");
/* 348 */     for (EscherRecord escherRecord : getEscherRecords()) {
/* 349 */       stringBuilder.append(escherRecord.toXml(paramString + "\t"));
/*     */     }
/* 351 */     stringBuilder.append(paramString).append("</").append(getRecordName()).append(">\n");
/* 352 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isDrawingLayerRecord(short paramShort) {
/* 360 */     return (paramShort == 236 || paramShort == 60 || paramShort == 93 || paramShort == 438);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static EscherAggregate createAggregate(List<RecordBase> paramList, int paramInt) {
/* 378 */     final ArrayList<EscherRecord> shapeRecords = new ArrayList();
/* 379 */     DefaultEscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory() {
/*     */         public EscherRecord createRecord(byte[] param1ArrayOfbyte, int param1Int) {
/* 381 */           EscherRecord escherRecord = super.createRecord(param1ArrayOfbyte, param1Int);
/* 382 */           if (escherRecord.getRecordId() == -4079 || escherRecord.getRecordId() == -4083) {
/* 383 */             shapeRecords.add(escherRecord);
/*     */           }
/* 385 */           return escherRecord;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 390 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 391 */     EscherAggregate escherAggregate = new EscherAggregate(false);
/* 392 */     int i = paramInt;
/*     */     
/* 394 */     while (i + 1 < paramList.size() && isDrawingLayerRecord(sid(paramList, i))) {
/*     */       try {
/* 396 */         if (sid(paramList, i) != 236 && sid(paramList, i) != 60) {
/* 397 */           i++;
/*     */           continue;
/*     */         } 
/* 400 */         if (sid(paramList, i) == 236) {
/* 401 */           byteArrayOutputStream.write(((DrawingRecord)paramList.get(i)).getRecordData());
/*     */         } else {
/* 403 */           byteArrayOutputStream.write(((ContinueRecord)paramList.get(i)).getData());
/*     */         } 
/* 405 */       } catch (IOException iOException) {
/* 406 */         throw new RuntimeException("Couldn't get data from drawing/continue records", iOException);
/*     */       } 
/* 408 */       i++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 413 */     int j = 0;
/* 414 */     while (j < byteArrayOutputStream.size()) {
/* 415 */       EscherRecord escherRecord = defaultEscherRecordFactory.createRecord(byteArrayOutputStream.toByteArray(), j);
/* 416 */       int m = escherRecord.fillFields(byteArrayOutputStream.toByteArray(), j, (EscherRecordFactory)defaultEscherRecordFactory);
/* 417 */       escherAggregate.addEscherRecord(escherRecord);
/* 418 */       j += m;
/*     */     } 
/*     */ 
/*     */     
/* 422 */     i = paramInt + 1;
/* 423 */     byte b = 0;
/*     */     
/* 425 */     while (i < paramList.size() && isDrawingLayerRecord(sid(paramList, i))) {
/* 426 */       if (!isObjectRecord(paramList, i)) {
/* 427 */         i++;
/*     */         continue;
/*     */       } 
/* 430 */       Record record = (Record)paramList.get(i);
/* 431 */       escherAggregate.shapeToObj.put(arrayList.get(b++), record);
/* 432 */       i++;
/*     */     } 
/*     */ 
/*     */     
/* 436 */     while (i < paramList.size() && 
/* 437 */       sid(paramList, i) == 28) {
/* 438 */       NoteRecord noteRecord = (NoteRecord)paramList.get(i);
/* 439 */       escherAggregate.tailRec.put(Integer.valueOf(noteRecord.getShapeId()), noteRecord);
/*     */ 
/*     */ 
/*     */       
/* 443 */       i++;
/*     */     } 
/*     */     
/* 446 */     int k = i;
/*     */     
/* 448 */     paramList.subList(paramInt, k).clear();
/* 449 */     paramList.add(paramInt, escherAggregate);
/* 450 */     return escherAggregate;
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
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 463 */     List<EscherRecord> list = getEscherRecords();
/* 464 */     int i = getEscherRecordSize(list);
/* 465 */     byte[] arrayOfByte = new byte[i];
/*     */ 
/*     */     
/* 468 */     final ArrayList<Integer> spEndingOffsets = new ArrayList();
/* 469 */     final ArrayList shapes = new ArrayList();
/* 470 */     int j = 0;
/* 471 */     for (EscherRecord escherRecord1 : list) {
/* 472 */       EscherRecord escherRecord2 = escherRecord1;
/* 473 */       j += escherRecord2.serialize(j, arrayOfByte, new EscherSerializationListener()
/*     */           {
/*     */             public void beforeRecordSerialize(int param1Int, short param1Short, EscherRecord param1EscherRecord) {}
/*     */             
/*     */             public void afterRecordSerialize(int param1Int1, short param1Short, int param1Int2, EscherRecord param1EscherRecord) {
/* 478 */               if (param1Short == -4079 || param1Short == -4083) {
/* 479 */                 spEndingOffsets.add(Integer.valueOf(param1Int1));
/* 480 */                 shapes.add(param1EscherRecord);
/*     */               } 
/*     */             }
/*     */           });
/*     */     } 
/* 485 */     arrayList1.add(0, null);
/* 486 */     arrayList.add(0, Integer.valueOf(0));
/*     */ 
/*     */ 
/*     */     
/* 490 */     j = paramInt;
/* 491 */     int k = 0;
/*     */     byte b;
/* 493 */     for (b = 1; b < arrayList1.size(); b++) {
/* 494 */       int i1, n = ((Integer)arrayList.get(b)).intValue() - 1;
/*     */       
/* 496 */       if (b == 1) {
/* 497 */         i1 = 0;
/*     */       } else {
/* 499 */         i1 = ((Integer)arrayList.get(b - 1)).intValue();
/*     */       } 
/* 501 */       byte[] arrayOfByte1 = new byte[n - i1 + 1];
/* 502 */       System.arraycopy(arrayOfByte, i1, arrayOfByte1, 0, arrayOfByte1.length);
/* 503 */       j += writeDataIntoDrawingRecord(arrayOfByte1, k, j, paramArrayOfbyte, b);
/*     */       
/* 505 */       k += arrayOfByte1.length;
/*     */ 
/*     */       
/* 508 */       Record record = this.shapeToObj.get(arrayList1.get(b));
/* 509 */       j += record.serialize(j, paramArrayOfbyte);
/*     */       
/* 511 */       if (b == arrayList1.size() - 1 && n < arrayOfByte.length - 1) {
/* 512 */         arrayOfByte1 = new byte[arrayOfByte.length - n - 1];
/* 513 */         System.arraycopy(arrayOfByte, n + 1, arrayOfByte1, 0, arrayOfByte1.length);
/* 514 */         j += writeDataIntoDrawingRecord(arrayOfByte1, k, j, paramArrayOfbyte, b);
/*     */       } 
/*     */     } 
/* 517 */     if (j - paramInt < arrayOfByte.length - 1) {
/* 518 */       byte[] arrayOfByte1 = new byte[arrayOfByte.length - j - paramInt];
/* 519 */       System.arraycopy(arrayOfByte, j - paramInt, arrayOfByte1, 0, arrayOfByte1.length);
/* 520 */       j += writeDataIntoDrawingRecord(arrayOfByte1, k, j, paramArrayOfbyte, b);
/*     */     } 
/*     */     
/* 523 */     for (NoteRecord noteRecord1 : this.tailRec.values()) {
/* 524 */       NoteRecord noteRecord2 = noteRecord1;
/* 525 */       j += noteRecord2.serialize(j, paramArrayOfbyte);
/*     */     } 
/* 527 */     int m = j - paramInt;
/* 528 */     if (m != getRecordSize())
/* 529 */       throw new RecordFormatException(m + " bytes written but getRecordSize() reports " + getRecordSize()); 
/* 530 */     return m;
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
/*     */   private int writeDataIntoDrawingRecord(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3) {
/* 543 */     int i = 0;
/*     */     
/* 545 */     if (paramInt1 + paramArrayOfbyte1.length > 8224 && paramInt3 != 1) {
/* 546 */       for (byte b = 0; b < paramArrayOfbyte1.length; b += 8224) {
/* 547 */         byte[] arrayOfByte = new byte[Math.min(8224, paramArrayOfbyte1.length - b)];
/* 548 */         System.arraycopy(paramArrayOfbyte1, b, arrayOfByte, 0, Math.min(8224, paramArrayOfbyte1.length - b));
/* 549 */         ContinueRecord continueRecord = new ContinueRecord(arrayOfByte);
/* 550 */         i += continueRecord.serialize(paramInt2 + i, paramArrayOfbyte2);
/*     */       } 
/*     */     } else {
/* 553 */       for (byte b = 0; b < paramArrayOfbyte1.length; b += 8224) {
/* 554 */         if (b == 0) {
/* 555 */           DrawingRecord drawingRecord = new DrawingRecord();
/* 556 */           byte[] arrayOfByte = new byte[Math.min(8224, paramArrayOfbyte1.length - b)];
/* 557 */           System.arraycopy(paramArrayOfbyte1, b, arrayOfByte, 0, Math.min(8224, paramArrayOfbyte1.length - b));
/* 558 */           drawingRecord.setData(arrayOfByte);
/* 559 */           i += drawingRecord.serialize(paramInt2 + i, paramArrayOfbyte2);
/*     */         } else {
/* 561 */           byte[] arrayOfByte = new byte[Math.min(8224, paramArrayOfbyte1.length - b)];
/* 562 */           System.arraycopy(paramArrayOfbyte1, b, arrayOfByte, 0, Math.min(8224, paramArrayOfbyte1.length - b));
/* 563 */           ContinueRecord continueRecord = new ContinueRecord(arrayOfByte);
/* 564 */           i += continueRecord.serialize(paramInt2 + i, paramArrayOfbyte2);
/*     */         } 
/*     */       } 
/*     */     } 
/* 568 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getEscherRecordSize(List<EscherRecord> paramList) {
/* 578 */     int i = 0;
/* 579 */     for (EscherRecord escherRecord : paramList) {
/* 580 */       i += escherRecord.getRecordSize();
/*     */     }
/* 582 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 591 */     int i = 0;
/*     */     
/* 593 */     List<EscherRecord> list = getEscherRecords();
/* 594 */     int j = getEscherRecordSize(list);
/* 595 */     byte[] arrayOfByte = new byte[j];
/* 596 */     final ArrayList<Integer> spEndingOffsets = new ArrayList();
/* 597 */     int k = 0;
/* 598 */     for (EscherRecord escherRecord : list) {
/* 599 */       k += escherRecord.serialize(k, arrayOfByte, new EscherSerializationListener()
/*     */           {
/*     */             public void beforeRecordSerialize(int param1Int, short param1Short, EscherRecord param1EscherRecord) {}
/*     */             
/*     */             public void afterRecordSerialize(int param1Int1, short param1Short, int param1Int2, EscherRecord param1EscherRecord) {
/* 604 */               if (param1Short == -4079 || param1Short == -4083) {
/* 605 */                 spEndingOffsets.add(Integer.valueOf(param1Int1));
/*     */               }
/*     */             }
/*     */           });
/*     */     } 
/* 610 */     arrayList.add(0, Integer.valueOf(0));
/*     */     int m;
/* 612 */     for (m = 1; m < arrayList.size(); m++) {
/* 613 */       if (m == arrayList.size() - 1 && ((Integer)arrayList.get(m)).intValue() < k) {
/* 614 */         i += true;
/*     */       }
/* 616 */       if (((Integer)arrayList.get(m)).intValue() - ((Integer)arrayList.get(m - 1)).intValue() > 8224)
/*     */       {
/*     */         
/* 619 */         i += (((Integer)arrayList.get(m)).intValue() - ((Integer)arrayList.get(m - 1)).intValue()) / 8224 * 4;
/*     */       }
/*     */     } 
/* 622 */     m = j + this.shapeToObj.size() * 4;
/* 623 */     if (j != 0 && arrayList.size() == 1) {
/* 624 */       i += 4;
/*     */     }
/* 626 */     int n = 0;
/* 627 */     for (Record record : this.shapeToObj.values()) {
/* 628 */       n += record.getRecordSize();
/*     */     }
/* 630 */     int i1 = 0;
/* 631 */     for (NoteRecord noteRecord : this.tailRec.values()) {
/* 632 */       i1 += noteRecord.getRecordSize();
/*     */     }
/* 634 */     return m + n + i1 + i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void associateShapeToObjRecord(EscherRecord paramEscherRecord, Record paramRecord) {
/* 643 */     this.shapeToObj.put(paramEscherRecord, paramRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeShapeToObjRecord(EscherRecord paramEscherRecord) {
/* 651 */     this.shapeToObj.remove(paramEscherRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/* 658 */     return "ESCHERAGGREGATE";
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
/*     */   private static boolean isObjectRecord(List<RecordBase> paramList, int paramInt) {
/* 670 */     return (sid(paramList, paramInt) == 93 || sid(paramList, paramInt) == 438);
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
/*     */   
/*     */   private void buildBaseTree() {
/* 686 */     EscherContainerRecord escherContainerRecord1 = new EscherContainerRecord();
/* 687 */     EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
/* 688 */     EscherContainerRecord escherContainerRecord3 = new EscherContainerRecord();
/* 689 */     EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
/* 690 */     EscherSpRecord escherSpRecord = new EscherSpRecord();
/* 691 */     escherContainerRecord1.setRecordId((short)-4094);
/* 692 */     escherContainerRecord1.setOptions((short)15);
/* 693 */     EscherDgRecord escherDgRecord = new EscherDgRecord();
/* 694 */     escherDgRecord.setRecordId((short)-4088);
/* 695 */     byte b = 1;
/* 696 */     escherDgRecord.setOptions((short)(b << 4));
/* 697 */     escherDgRecord.setNumShapes(0);
/* 698 */     escherDgRecord.setLastMSOSPID(1024);
/* 699 */     escherContainerRecord2.setRecordId((short)-4093);
/* 700 */     escherContainerRecord2.setOptions((short)15);
/* 701 */     escherContainerRecord3.setRecordId((short)-4092);
/* 702 */     escherContainerRecord3.setOptions((short)15);
/* 703 */     escherSpgrRecord.setRecordId((short)-4087);
/* 704 */     escherSpgrRecord.setOptions((short)1);
/* 705 */     escherSpgrRecord.setRectX1(0);
/* 706 */     escherSpgrRecord.setRectY1(0);
/* 707 */     escherSpgrRecord.setRectX2(1023);
/* 708 */     escherSpgrRecord.setRectY2(255);
/* 709 */     escherSpRecord.setRecordId((short)-4086);
/*     */     
/* 711 */     escherSpRecord.setOptions((short)2);
/* 712 */     escherSpRecord.setVersion((short)2);
/* 713 */     escherSpRecord.setShapeId(-1);
/* 714 */     escherSpRecord.setFlags(5);
/* 715 */     escherContainerRecord1.addChildRecord((EscherRecord)escherDgRecord);
/* 716 */     escherContainerRecord1.addChildRecord((EscherRecord)escherContainerRecord2);
/* 717 */     escherContainerRecord2.addChildRecord((EscherRecord)escherContainerRecord3);
/* 718 */     escherContainerRecord3.addChildRecord((EscherRecord)escherSpgrRecord);
/* 719 */     escherContainerRecord3.addChildRecord((EscherRecord)escherSpRecord);
/* 720 */     addEscherRecord((EscherRecord)escherContainerRecord1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDgId(short paramShort) {
/* 731 */     EscherContainerRecord escherContainerRecord = getEscherContainer();
/* 732 */     EscherDgRecord escherDgRecord = (EscherDgRecord)escherContainerRecord.getChildById((short)-4088);
/* 733 */     escherDgRecord.setOptions((short)(paramShort << 4));
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
/*     */   public void setMainSpRecordId(int paramInt) {
/* 748 */     EscherContainerRecord escherContainerRecord1 = getEscherContainer();
/* 749 */     EscherContainerRecord escherContainerRecord2 = (EscherContainerRecord)escherContainerRecord1.getChildById((short)-4093);
/* 750 */     EscherContainerRecord escherContainerRecord3 = (EscherContainerRecord)escherContainerRecord2.getChild(0);
/* 751 */     EscherSpRecord escherSpRecord = (EscherSpRecord)escherContainerRecord3.getChildById((short)-4086);
/* 752 */     escherSpRecord.setShapeId(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static short sid(List<RecordBase> paramList, int paramInt) {
/* 761 */     RecordBase recordBase = paramList.get(paramInt);
/* 762 */     if (recordBase instanceof Record) {
/* 763 */       return ((Record)recordBase).getSid();
/*     */     }
/*     */ 
/*     */     
/* 767 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<EscherRecord, Record> getShapeToObjMapping() {
/* 778 */     return Collections.unmodifiableMap(this.shapeToObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, NoteRecord> getTailRecords() {
/* 786 */     return Collections.unmodifiableMap(this.tailRec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NoteRecord getNoteRecordByObj(ObjRecord paramObjRecord) {
/* 794 */     CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord)paramObjRecord.getSubRecords().get(0);
/* 795 */     return this.tailRec.get(Integer.valueOf(commonObjectDataSubRecord.getObjectId()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTailRecord(NoteRecord paramNoteRecord) {
/* 803 */     this.tailRec.put(Integer.valueOf(paramNoteRecord.getShapeId()), paramNoteRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTailRecord(NoteRecord paramNoteRecord) {
/* 811 */     this.tailRec.remove(Integer.valueOf(paramNoteRecord.getShapeId()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\EscherAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */