/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.sl.usermodel.Resources;
/*     */ import org.apache.poi.sl.usermodel.Slide;
/*     */ import org.apache.poi.sl.usermodel.SlideShow;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.PackageHelper;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdListEntry;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLSlideShow
/*     */   extends POIXMLDocument
/*     */   implements SlideShow<XSLFShape, XSLFTextParagraph>
/*     */ {
/*  75 */   private static POILogger _logger = POILogFactory.getLogger(XMLSlideShow.class);
/*     */   
/*     */   private CTPresentation _presentation;
/*     */   private List<XSLFSlide> _slides;
/*     */   private List<XSLFSlideMaster> _masters;
/*     */   private List<XSLFPictureData> _pictures;
/*     */   private XSLFTableStyles _tableStyles;
/*     */   private XSLFNotesMaster _notesMaster;
/*     */   private XSLFCommentAuthors _commentAuthors;
/*     */   
/*     */   public XMLSlideShow() {
/*  86 */     this(empty());
/*     */   }
/*     */   
/*     */   public XMLSlideShow(OPCPackage paramOPCPackage) {
/*  90 */     super(paramOPCPackage);
/*     */     
/*     */     try {
/*  93 */       if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
/*  94 */         rebase(getPackage());
/*     */       }
/*     */ 
/*     */       
/*  98 */       load(XSLFFactory.getInstance());
/*  99 */     } catch (Exception exception) {
/* 100 */       throw new POIXMLException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public XMLSlideShow(InputStream paramInputStream) throws IOException {
/* 105 */     this(PackageHelper.open(paramInputStream));
/*     */   }
/*     */   
/*     */   static OPCPackage empty() {
/* 109 */     InputStream inputStream = XMLSlideShow.class.getResourceAsStream("empty.pptx");
/* 110 */     if (inputStream == null) {
/* 111 */       throw new POIXMLException("Missing resource 'empty.pptx'");
/*     */     }
/*     */     try {
/* 114 */       return OPCPackage.open(inputStream);
/* 115 */     } catch (Exception exception) {
/* 116 */       throw new POIXMLException(exception);
/*     */     } finally {
/*     */       try {
/* 119 */         inputStream.close();
/* 120 */       } catch (Exception exception) {
/* 121 */         throw new POIXMLException(exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*     */     try {
/* 129 */       PresentationDocument presentationDocument = PresentationDocument.Factory.parse(getCorePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */       
/* 131 */       this._presentation = presentationDocument.getPresentation();
/*     */       
/* 133 */       HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 134 */       HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 135 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/* 136 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/* 137 */         if (pOIXMLDocumentPart instanceof XSLFSlide) {
/* 138 */           hashMap2.put(relationPart.getRelationship().getId(), pOIXMLDocumentPart); continue;
/* 139 */         }  if (pOIXMLDocumentPart instanceof XSLFSlideMaster) {
/* 140 */           hashMap1.put(getRelationId(pOIXMLDocumentPart), pOIXMLDocumentPart); continue;
/* 141 */         }  if (pOIXMLDocumentPart instanceof XSLFTableStyles) {
/* 142 */           this._tableStyles = (XSLFTableStyles)pOIXMLDocumentPart; continue;
/* 143 */         }  if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
/* 144 */           this._notesMaster = (XSLFNotesMaster)pOIXMLDocumentPart; continue;
/* 145 */         }  if (pOIXMLDocumentPart instanceof XSLFCommentAuthors) {
/* 146 */           this._commentAuthors = (XSLFCommentAuthors)pOIXMLDocumentPart;
/*     */         }
/*     */       } 
/*     */       
/* 150 */       this._masters = new ArrayList<XSLFSlideMaster>(hashMap1.size());
/* 151 */       for (CTSlideMasterIdListEntry cTSlideMasterIdListEntry : this._presentation.getSldMasterIdLst().getSldMasterIdList()) {
/* 152 */         XSLFSlideMaster xSLFSlideMaster = (XSLFSlideMaster)hashMap1.get(cTSlideMasterIdListEntry.getId2());
/* 153 */         this._masters.add(xSLFSlideMaster);
/*     */       } 
/*     */       
/* 156 */       this._slides = new ArrayList<XSLFSlide>(hashMap2.size());
/* 157 */       if (this._presentation.isSetSldIdLst()) {
/* 158 */         for (CTSlideIdListEntry cTSlideIdListEntry : this._presentation.getSldIdLst().getSldIdList()) {
/* 159 */           XSLFSlide xSLFSlide = (XSLFSlide)hashMap2.get(cTSlideIdListEntry.getId2());
/* 160 */           if (xSLFSlide == null) {
/* 161 */             _logger.log(5, new Object[] { "Slide with r:id " + cTSlideIdListEntry.getId() + " was defined, but didn't exist in package, skipping" });
/*     */             continue;
/*     */           } 
/* 164 */           this._slides.add(xSLFSlide);
/*     */         } 
/*     */       }
/* 167 */     } catch (XmlException xmlException) {
/* 168 */       throw new POIXMLException(xmlException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 174 */     PackagePart packagePart = getPackagePart();
/* 175 */     OutputStream outputStream = packagePart.getOutputStream();
/* 176 */     this._presentation.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 177 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
/* 185 */     return Collections.unmodifiableList(getPackage().getPartsByName(Pattern.compile("/ppt/embeddings/.*?")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSLFPictureData> getPictureData() {
/* 192 */     if (this._pictures == null) {
/* 193 */       List list = getPackage().getPartsByName(Pattern.compile("/ppt/media/.*?"));
/* 194 */       this._pictures = new ArrayList<XSLFPictureData>(list.size());
/* 195 */       for (PackagePart packagePart : list) {
/* 196 */         XSLFPictureData xSLFPictureData = new XSLFPictureData(packagePart);
/* 197 */         xSLFPictureData.setIndex(this._pictures.size());
/* 198 */         this._pictures.add(xSLFPictureData);
/*     */       } 
/*     */     } 
/* 201 */     return Collections.unmodifiableList(this._pictures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlide createSlide(XSLFSlideLayout paramXSLFSlideLayout) {
/*     */     CTSlideIdList cTSlideIdList;
/* 211 */     int i = 256; byte b = 1;
/*     */     
/* 213 */     if (!this._presentation.isSetSldIdLst()) { cTSlideIdList = this._presentation.addNewSldIdLst(); }
/*     */     else
/* 215 */     { cTSlideIdList = this._presentation.getSldIdLst();
/* 216 */       for (CTSlideIdListEntry cTSlideIdListEntry1 : cTSlideIdList.getSldIdArray()) {
/* 217 */         i = (int)Math.max(cTSlideIdListEntry1.getId() + 1L, i);
/* 218 */         b++;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 224 */         String str = XSLFRelation.SLIDE.getFileName(b);
/* 225 */         boolean bool = false;
/* 226 */         for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 227 */           if (pOIXMLDocumentPart.getPackagePart() != null && str.equals(pOIXMLDocumentPart.getPackagePart().getPartName().getName())) {
/*     */ 
/*     */             
/* 230 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 235 */         if (!bool && getPackage().getPartsByName(Pattern.compile(Pattern.quote(str))).size() > 0)
/*     */         {
/*     */           
/* 238 */           bool = true;
/*     */         }
/*     */         
/* 241 */         if (!bool) {
/*     */           break;
/*     */         }
/* 244 */         b++;
/*     */       }  }
/*     */ 
/*     */     
/* 248 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSLFRelation.SLIDE, XSLFFactory.getInstance(), b, false);
/*     */     
/* 250 */     XSLFSlide xSLFSlide = (XSLFSlide)relationPart.getDocumentPart();
/*     */     
/* 252 */     CTSlideIdListEntry cTSlideIdListEntry = cTSlideIdList.addNewSldId();
/* 253 */     cTSlideIdListEntry.setId(i);
/* 254 */     cTSlideIdListEntry.setId2(relationPart.getRelationship().getId());
/*     */     
/* 256 */     paramXSLFSlideLayout.copyLayout(xSLFSlide);
/* 257 */     xSLFSlide.addRelation(null, XSLFRelation.SLIDE_LAYOUT, paramXSLFSlideLayout);
/*     */     
/* 259 */     this._slides.add(xSLFSlide);
/* 260 */     return xSLFSlide;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlide createSlide() {
/* 268 */     XSLFSlideLayout xSLFSlideLayout = ((XSLFSlideMaster)this._masters.get(0)).getLayout(SlideLayout.BLANK);
/* 269 */     if (xSLFSlideLayout == null) throw new IllegalArgumentException("Blank layout was not found");
/*     */     
/* 271 */     return createSlide(xSLFSlideLayout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFNotes getNotesSlide(XSLFSlide paramXSLFSlide) {
/* 279 */     XSLFNotes xSLFNotes = paramXSLFSlide.getNotes();
/* 280 */     if (xSLFNotes == null) {
/* 281 */       xSLFNotes = createNotesSlide(paramXSLFSlide);
/*     */     }
/*     */     
/* 284 */     return xSLFNotes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XSLFNotes createNotesSlide(XSLFSlide paramXSLFSlide) {
/* 292 */     if (this._notesMaster == null) {
/* 293 */       createNotesMaster();
/*     */     }
/*     */     
/* 296 */     Integer integer = XSLFRelation.SLIDE.getFileNameIndex(paramXSLFSlide);
/*     */ 
/*     */     
/* 299 */     XSLFNotes xSLFNotes = (XSLFNotes)createRelationship(XSLFRelation.NOTES, XSLFFactory.getInstance(), integer.intValue());
/*     */ 
/*     */     
/* 302 */     paramXSLFSlide.addRelation(null, XSLFRelation.NOTES, xSLFNotes);
/* 303 */     xSLFNotes.addRelation(null, XSLFRelation.NOTES_MASTER, this._notesMaster);
/* 304 */     xSLFNotes.addRelation(null, XSLFRelation.SLIDE, paramXSLFSlide);
/*     */     
/* 306 */     xSLFNotes.importContent(this._notesMaster);
/*     */     
/* 308 */     return xSLFNotes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createNotesMaster() {
/* 315 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSLFRelation.NOTES_MASTER, XSLFFactory.getInstance(), 1, false);
/*     */     
/* 317 */     this._notesMaster = (XSLFNotesMaster)relationPart.getDocumentPart();
/*     */     
/* 319 */     CTNotesMasterIdList cTNotesMasterIdList = this._presentation.addNewNotesMasterIdLst();
/* 320 */     CTNotesMasterIdListEntry cTNotesMasterIdListEntry = cTNotesMasterIdList.addNewNotesMasterId();
/* 321 */     cTNotesMasterIdListEntry.setId(relationPart.getRelationship().getId());
/*     */     
/* 323 */     Integer integer = Integer.valueOf(1);
/*     */     
/* 325 */     ArrayList<Integer> arrayList = new ArrayList();
/* 326 */     for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 327 */       if (pOIXMLDocumentPart instanceof XSLFTheme) {
/* 328 */         arrayList.add(XSLFRelation.THEME.getFileNameIndex(pOIXMLDocumentPart));
/*     */       }
/*     */     } 
/*     */     
/* 332 */     if (!arrayList.isEmpty()) {
/* 333 */       Boolean bool = Boolean.valueOf(false);
/* 334 */       for (Integer integer1 = Integer.valueOf(1); integer1.intValue() <= arrayList.size(); integer2 = integer1, integer3 = integer1 = Integer.valueOf(integer1.intValue() + 1)) {
/* 335 */         Integer integer2; Integer integer3; if (!arrayList.contains(integer1)) {
/* 336 */           bool = Boolean.valueOf(true);
/* 337 */           integer = integer1;
/*     */         } 
/*     */       } 
/* 340 */       if (!bool.booleanValue()) {
/* 341 */         integer = Integer.valueOf(arrayList.size() + 1);
/*     */       }
/*     */     } 
/*     */     
/* 345 */     XSLFTheme xSLFTheme = (XSLFTheme)createRelationship(XSLFRelation.THEME, XSLFFactory.getInstance(), integer.intValue());
/*     */     
/* 347 */     xSLFTheme.importTheme(((XSLFSlide)getSlides().get(0)).getTheme());
/*     */     
/* 349 */     this._notesMaster.addRelation(null, XSLFRelation.THEME, xSLFTheme);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFNotesMaster getNotesMaster() {
/* 357 */     return this._notesMaster;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<XSLFSlideMaster> getSlideMasters() {
/* 362 */     return this._masters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSLFSlide> getSlides() {
/* 369 */     return this._slides;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFCommentAuthors getCommentAuthors() {
/* 377 */     return this._commentAuthors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlideOrder(XSLFSlide paramXSLFSlide, int paramInt) {
/* 385 */     int i = this._slides.indexOf(paramXSLFSlide);
/* 386 */     if (i == -1) throw new IllegalArgumentException("Slide not found"); 
/* 387 */     if (i == paramInt) {
/*     */       return;
/*     */     }
/* 390 */     this._slides.add(paramInt, this._slides.remove(i));
/*     */ 
/*     */     
/* 393 */     CTSlideIdList cTSlideIdList = this._presentation.getSldIdLst();
/* 394 */     CTSlideIdListEntry[] arrayOfCTSlideIdListEntry = cTSlideIdList.getSldIdArray();
/* 395 */     CTSlideIdListEntry cTSlideIdListEntry = arrayOfCTSlideIdListEntry[i];
/* 396 */     if (i < paramInt) {
/* 397 */       System.arraycopy(arrayOfCTSlideIdListEntry, i + 1, arrayOfCTSlideIdListEntry, i, paramInt - i);
/*     */     } else {
/* 399 */       System.arraycopy(arrayOfCTSlideIdListEntry, paramInt, arrayOfCTSlideIdListEntry, paramInt + 1, i - paramInt);
/*     */     } 
/* 401 */     arrayOfCTSlideIdListEntry[paramInt] = cTSlideIdListEntry;
/* 402 */     cTSlideIdList.setSldIdArray(arrayOfCTSlideIdListEntry);
/*     */   }
/*     */   
/*     */   public XSLFSlide removeSlide(int paramInt) {
/* 406 */     XSLFSlide xSLFSlide = this._slides.remove(paramInt);
/* 407 */     removeRelation(xSLFSlide);
/* 408 */     this._presentation.getSldIdLst().removeSldId(paramInt);
/* 409 */     return xSLFSlide;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getPageSize() {
/* 414 */     CTSlideSize cTSlideSize = this._presentation.getSldSz();
/* 415 */     int i = cTSlideSize.getCx();
/* 416 */     int j = cTSlideSize.getCy();
/* 417 */     return new Dimension((int)Units.toPoints(i), (int)Units.toPoints(j));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPageSize(Dimension paramDimension) {
/* 422 */     CTSlideSize cTSlideSize = CTSlideSize.Factory.newInstance();
/* 423 */     cTSlideSize.setCx(Units.toEMU(paramDimension.getWidth()));
/* 424 */     cTSlideSize.setCy(Units.toEMU(paramDimension.getHeight()));
/* 425 */     this._presentation.setSldSz(cTSlideSize);
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTPresentation getCTPresentation() {
/* 431 */     return this._presentation;
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
/*     */   public XSLFPictureData addPicture(byte[] paramArrayOfbyte, PictureData.PictureType paramPictureType) {
/* 443 */     XSLFPictureData xSLFPictureData = findPictureData(paramArrayOfbyte);
/*     */     
/* 445 */     if (xSLFPictureData != null) return xSLFPictureData;
/*     */     
/* 447 */     int i = this._pictures.size();
/* 448 */     XSLFRelation xSLFRelation = XSLFPictureData.getRelationForType(paramPictureType);
/* 449 */     if (xSLFRelation == null) {
/* 450 */       throw new IllegalArgumentException("Picture type " + paramPictureType + " is not supported.");
/*     */     }
/* 452 */     xSLFPictureData = (XSLFPictureData)createRelationship(xSLFRelation, XSLFFactory.getInstance(), i + 1, true).getDocumentPart();
/* 453 */     xSLFPictureData.setIndex(i);
/* 454 */     this._pictures.add(xSLFPictureData);
/*     */     try {
/* 456 */       OutputStream outputStream = xSLFPictureData.getPackagePart().getOutputStream();
/* 457 */       outputStream.write(paramArrayOfbyte);
/* 458 */       outputStream.close();
/* 459 */     } catch (IOException iOException) {
/* 460 */       throw new POIXMLException(iOException);
/*     */     } 
/*     */     
/* 463 */     return xSLFPictureData;
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
/*     */   public XSLFPictureData addPicture(InputStream paramInputStream, PictureData.PictureType paramPictureType) throws IOException {
/* 479 */     return addPicture(IOUtils.toByteArray(paramInputStream), paramPictureType);
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
/*     */   public XSLFPictureData addPicture(File paramFile, PictureData.PictureType paramPictureType) throws IOException {
/* 495 */     int i = (int)paramFile.length();
/* 496 */     byte[] arrayOfByte = new byte[i];
/* 497 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/* 499 */       IOUtils.readFully(fileInputStream, arrayOfByte);
/*     */     } finally {
/* 501 */       fileInputStream.close();
/*     */     } 
/* 503 */     return addPicture(arrayOfByte, paramPictureType);
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
/*     */   public XSLFPictureData findPictureData(byte[] paramArrayOfbyte) {
/* 516 */     long l = IOUtils.calculateChecksum(paramArrayOfbyte);
/* 517 */     byte[] arrayOfByte = new byte[8];
/* 518 */     LittleEndian.putLong(arrayOfByte, 0, l);
/*     */     
/* 520 */     for (XSLFPictureData xSLFPictureData : getPictureData()) {
/* 521 */       if (Arrays.equals(xSLFPictureData.getChecksum(), arrayOfByte)) {
/* 522 */         return xSLFPictureData;
/*     */       }
/*     */     } 
/* 525 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFSlideLayout findLayout(String paramString) {
/* 536 */     for (XSLFSlideMaster xSLFSlideMaster : getSlideMasters()) {
/* 537 */       XSLFSlideLayout xSLFSlideLayout = xSLFSlideMaster.getLayout(paramString);
/* 538 */       if (xSLFSlideLayout != null) {
/* 539 */         return xSLFSlideLayout;
/*     */       }
/*     */     } 
/* 542 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTableStyles getTableStyles() {
/* 547 */     return this._tableStyles;
/*     */   }
/*     */   
/*     */   CTTextParagraphProperties getDefaultParagraphStyle(int paramInt) {
/* 551 */     XmlObject[] arrayOfXmlObject = this._presentation.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:defaultTextStyle/a:lvl" + (paramInt + 1) + "pPr");
/*     */ 
/*     */ 
/*     */     
/* 555 */     if (arrayOfXmlObject.length == 1) {
/* 556 */       return (CTTextParagraphProperties)arrayOfXmlObject[0];
/*     */     }
/* 558 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MasterSheet<XSLFShape, XSLFTextParagraph> createMasterSheet() throws IOException {
/* 564 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Resources getResources() {
/* 569 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XMLSlideShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */