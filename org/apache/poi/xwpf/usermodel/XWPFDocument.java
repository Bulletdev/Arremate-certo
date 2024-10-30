/*      */ package org.apache.poi.xwpf.usermodel;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.poi.POIXMLDocument;
/*      */ import org.apache.poi.POIXMLDocumentPart;
/*      */ import org.apache.poi.POIXMLException;
/*      */ import org.apache.poi.POIXMLProperties;
/*      */ import org.apache.poi.POIXMLRelation;
/*      */ import org.apache.poi.POIXMLTypeLoader;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*      */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*      */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*      */ import org.apache.poi.openxml4j.opc.PackagePart;
/*      */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*      */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*      */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*      */ import org.apache.poi.openxml4j.opc.TargetMode;
/*      */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*      */ import org.apache.poi.util.IOUtils;
/*      */ import org.apache.poi.util.IdentifierManager;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.PackageHelper;
/*      */ import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XWPFDocument
/*      */   extends POIXMLDocument
/*      */   implements Document, IBody
/*      */ {
/*   93 */   private static final POILogger LOG = POILogFactory.getLogger(XWPFDocument.class);
/*      */   
/*   95 */   protected List<XWPFFooter> footers = new ArrayList<XWPFFooter>();
/*   96 */   protected List<XWPFHeader> headers = new ArrayList<XWPFHeader>();
/*   97 */   protected List<XWPFComment> comments = new ArrayList<XWPFComment>();
/*   98 */   protected List<XWPFHyperlink> hyperlinks = new ArrayList<XWPFHyperlink>();
/*   99 */   protected List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>();
/*  100 */   protected List<XWPFTable> tables = new ArrayList<XWPFTable>();
/*  101 */   protected List<XWPFSDT> contentControls = new ArrayList<XWPFSDT>();
/*  102 */   protected List<IBodyElement> bodyElements = new ArrayList<IBodyElement>();
/*  103 */   protected List<XWPFPictureData> pictures = new ArrayList<XWPFPictureData>();
/*  104 */   protected Map<Long, List<XWPFPictureData>> packagePictures = new HashMap<Long, List<XWPFPictureData>>();
/*  105 */   protected Map<Integer, XWPFFootnote> endnotes = new HashMap<Integer, XWPFFootnote>();
/*      */   
/*      */   protected XWPFNumbering numbering;
/*      */   
/*      */   protected XWPFStyles styles;
/*      */   
/*      */   protected XWPFFootnotes footnotes;
/*      */   private CTDocument1 ctDocument;
/*      */   private XWPFSettings settings;
/*  114 */   private IdentifierManager drawingIdManager = new IdentifierManager(0L, 4294967295L);
/*      */ 
/*      */   
/*      */   private XWPFHeaderFooterPolicy headerFooterPolicy;
/*      */ 
/*      */   
/*      */   public XWPFDocument(OPCPackage paramOPCPackage) throws IOException {
/*  121 */     super(paramOPCPackage);
/*      */ 
/*      */     
/*  124 */     load(XWPFFactory.getInstance());
/*      */   }
/*      */   
/*      */   public XWPFDocument(InputStream paramInputStream) throws IOException {
/*  128 */     super(PackageHelper.open(paramInputStream));
/*      */ 
/*      */     
/*  131 */     load(XWPFFactory.getInstance());
/*      */   }
/*      */   
/*      */   public XWPFDocument() {
/*  135 */     super(newPackage());
/*  136 */     onDocumentCreate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static OPCPackage newPackage() {
/*      */     try {
/*  144 */       OPCPackage oPCPackage = OPCPackage.create(new ByteArrayOutputStream());
/*      */       
/*  146 */       PackagePartName packagePartName = PackagingURIHelper.createPartName(XWPFRelation.DOCUMENT.getDefaultFileName());
/*      */       
/*  148 */       oPCPackage.addRelationship(packagePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
/*      */       
/*  150 */       oPCPackage.createPart(packagePartName, XWPFRelation.DOCUMENT.getContentType());
/*      */       
/*  152 */       oPCPackage.getPackageProperties().setCreatorProperty("Apache POI");
/*      */       
/*  154 */       return oPCPackage;
/*  155 */     } catch (Exception exception) {
/*  156 */       throw new POIXMLException(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDocumentRead() throws IOException {
/*      */     try {
/*  164 */       DocumentDocument documentDocument = DocumentDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  165 */       this.ctDocument = documentDocument.getDocument();
/*      */       
/*  167 */       initFootnotes();
/*      */ 
/*      */ 
/*      */       
/*  171 */       XmlCursor xmlCursor = this.ctDocument.getBody().newCursor();
/*  172 */       xmlCursor.selectPath("./*");
/*  173 */       while (xmlCursor.toNextSelection()) {
/*  174 */         XmlObject xmlObject = xmlCursor.getObject();
/*  175 */         if (xmlObject instanceof CTP) {
/*  176 */           XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/*  177 */           this.bodyElements.add(xWPFParagraph);
/*  178 */           this.paragraphs.add(xWPFParagraph); continue;
/*  179 */         }  if (xmlObject instanceof CTTbl) {
/*  180 */           XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/*  181 */           this.bodyElements.add(xWPFTable);
/*  182 */           this.tables.add(xWPFTable); continue;
/*  183 */         }  if (xmlObject instanceof CTSdtBlock) {
/*  184 */           XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this);
/*  185 */           this.bodyElements.add(xWPFSDT);
/*  186 */           this.contentControls.add(xWPFSDT);
/*      */         } 
/*      */       } 
/*  189 */       xmlCursor.dispose();
/*      */ 
/*      */       
/*  192 */       if (documentDocument.getDocument().getBody().getSectPr() != null) {
/*  193 */         this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
/*      */       }
/*      */       
/*  196 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  197 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  198 */         String str = relationPart.getRelationship().getRelationshipType();
/*  199 */         if (str.equals(XWPFRelation.STYLES.getRelation())) {
/*  200 */           this.styles = (XWPFStyles)pOIXMLDocumentPart;
/*  201 */           this.styles.onDocumentRead(); continue;
/*  202 */         }  if (str.equals(XWPFRelation.NUMBERING.getRelation())) {
/*  203 */           this.numbering = (XWPFNumbering)pOIXMLDocumentPart;
/*  204 */           this.numbering.onDocumentRead(); continue;
/*  205 */         }  if (str.equals(XWPFRelation.FOOTER.getRelation())) {
/*  206 */           XWPFFooter xWPFFooter = (XWPFFooter)pOIXMLDocumentPart;
/*  207 */           this.footers.add(xWPFFooter);
/*  208 */           xWPFFooter.onDocumentRead(); continue;
/*  209 */         }  if (str.equals(XWPFRelation.HEADER.getRelation())) {
/*  210 */           XWPFHeader xWPFHeader = (XWPFHeader)pOIXMLDocumentPart;
/*  211 */           this.headers.add(xWPFHeader);
/*  212 */           xWPFHeader.onDocumentRead(); continue;
/*  213 */         }  if (str.equals(XWPFRelation.COMMENT.getRelation())) {
/*      */           
/*  215 */           CommentsDocument commentsDocument = CommentsDocument.Factory.parse(pOIXMLDocumentPart.getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  216 */           for (CTComment cTComment : commentsDocument.getComments().getCommentArray())
/*  217 */             this.comments.add(new XWPFComment(cTComment, this));  continue;
/*      */         } 
/*  219 */         if (str.equals(XWPFRelation.SETTINGS.getRelation())) {
/*  220 */           this.settings = (XWPFSettings)pOIXMLDocumentPart;
/*  221 */           this.settings.onDocumentRead(); continue;
/*  222 */         }  if (str.equals(XWPFRelation.IMAGES.getRelation())) {
/*  223 */           XWPFPictureData xWPFPictureData = (XWPFPictureData)pOIXMLDocumentPart;
/*  224 */           xWPFPictureData.onDocumentRead();
/*  225 */           registerPackagePictureData(xWPFPictureData);
/*  226 */           this.pictures.add(xWPFPictureData); continue;
/*  227 */         }  if (str.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation()))
/*      */         {
/*      */           
/*  230 */           for (POIXMLDocumentPart pOIXMLDocumentPart1 : pOIXMLDocumentPart.getRelations())
/*      */           {
/*      */ 
/*      */ 
/*      */             
/*  235 */             POIXMLDocumentPart._invokeOnDocumentRead(pOIXMLDocumentPart1);
/*      */           }
/*      */         }
/*      */       } 
/*  239 */       initHyperlinks();
/*  240 */     } catch (XmlException xmlException) {
/*  241 */       throw new POIXMLException(xmlException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void initHyperlinks() {
/*      */     try {
/*  249 */       Iterator<PackageRelationship> iterator = getPackagePart().getRelationshipsByType(XWPFRelation.HYPERLINK.getRelation()).iterator();
/*      */       
/*  251 */       while (iterator.hasNext()) {
/*  252 */         PackageRelationship packageRelationship = iterator.next();
/*  253 */         this.hyperlinks.add(new XWPFHyperlink(packageRelationship.getId(), packageRelationship.getTargetURI().toString()));
/*      */       } 
/*  255 */     } catch (InvalidFormatException invalidFormatException) {
/*  256 */       throw new POIXMLException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void initFootnotes() throws XmlException, IOException {
/*  261 */     for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  262 */       POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  263 */       String str = relationPart.getRelationship().getRelationshipType();
/*  264 */       if (str.equals(XWPFRelation.FOOTNOTE.getRelation())) {
/*  265 */         this.footnotes = (XWPFFootnotes)pOIXMLDocumentPart;
/*  266 */         this.footnotes.onDocumentRead(); continue;
/*  267 */       }  if (str.equals(XWPFRelation.ENDNOTE.getRelation())) {
/*  268 */         EndnotesDocument endnotesDocument = EndnotesDocument.Factory.parse(pOIXMLDocumentPart.getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*      */         
/*  270 */         for (CTFtnEdn cTFtnEdn : endnotesDocument.getEndnotes().getEndnoteArray()) {
/*  271 */           this.endnotes.put(Integer.valueOf(cTFtnEdn.getId().intValue()), new XWPFFootnote(this, cTFtnEdn));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDocumentCreate() {
/*  282 */     this.ctDocument = CTDocument1.Factory.newInstance();
/*  283 */     this.ctDocument.addNewBody();
/*      */     
/*  285 */     this.settings = (XWPFSettings)createRelationship(XWPFRelation.SETTINGS, XWPFFactory.getInstance());
/*      */     
/*  287 */     POIXMLProperties.ExtendedProperties extendedProperties = getProperties().getExtendedProperties();
/*  288 */     extendedProperties.getUnderlyingProperties().setApplication("Apache POI");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTDocument1 getDocument() {
/*  296 */     return this.ctDocument;
/*      */   }
/*      */   
/*      */   IdentifierManager getDrawingIdManager() {
/*  300 */     return this.drawingIdManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IBodyElement> getBodyElements() {
/*  310 */     return Collections.unmodifiableList(this.bodyElements);
/*      */   }
/*      */   
/*      */   public Iterator<IBodyElement> getBodyElementsIterator() {
/*  314 */     return this.bodyElements.iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFParagraph> getParagraphs() {
/*  322 */     return Collections.unmodifiableList(this.paragraphs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFTable> getTables() {
/*  330 */     return Collections.unmodifiableList(this.tables);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFTable getTableArray(int paramInt) {
/*  338 */     if (paramInt >= 0 && paramInt < this.tables.size()) {
/*  339 */       return this.tables.get(paramInt);
/*      */     }
/*  341 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFFooter> getFooterList() {
/*  348 */     return Collections.unmodifiableList(this.footers);
/*      */   }
/*      */   
/*      */   public XWPFFooter getFooterArray(int paramInt) {
/*  352 */     if (paramInt >= 0 && paramInt < this.footers.size()) {
/*  353 */       return this.footers.get(paramInt);
/*      */     }
/*  355 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFHeader> getHeaderList() {
/*  362 */     return Collections.unmodifiableList(this.headers);
/*      */   }
/*      */   
/*      */   public XWPFHeader getHeaderArray(int paramInt) {
/*  366 */     if (paramInt >= 0 && paramInt < this.headers.size()) {
/*  367 */       return this.headers.get(paramInt);
/*      */     }
/*  369 */     return null;
/*      */   }
/*      */   
/*      */   public String getTblStyle(XWPFTable paramXWPFTable) {
/*  373 */     return paramXWPFTable.getStyleID();
/*      */   }
/*      */   
/*      */   public XWPFHyperlink getHyperlinkByID(String paramString) {
/*  377 */     for (XWPFHyperlink xWPFHyperlink : this.hyperlinks) {
/*  378 */       if (xWPFHyperlink.getId().equals(paramString)) {
/*  379 */         return xWPFHyperlink;
/*      */       }
/*      */     } 
/*  382 */     return null;
/*      */   }
/*      */   
/*      */   public XWPFFootnote getFootnoteByID(int paramInt) {
/*  386 */     if (this.footnotes == null) return null; 
/*  387 */     return this.footnotes.getFootnoteById(paramInt);
/*      */   }
/*      */   
/*      */   public XWPFFootnote getEndnoteByID(int paramInt) {
/*  391 */     if (this.endnotes == null) return null; 
/*  392 */     return this.endnotes.get(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public List<XWPFFootnote> getFootnotes() {
/*  396 */     if (this.footnotes == null) {
/*  397 */       return Collections.emptyList();
/*      */     }
/*  399 */     return this.footnotes.getFootnotesList();
/*      */   }
/*      */   
/*      */   public XWPFHyperlink[] getHyperlinks() {
/*  403 */     return this.hyperlinks.<XWPFHyperlink>toArray(new XWPFHyperlink[this.hyperlinks.size()]);
/*      */   }
/*      */   
/*      */   public XWPFComment getCommentByID(String paramString) {
/*  407 */     for (XWPFComment xWPFComment : this.comments) {
/*  408 */       if (xWPFComment.getId().equals(paramString)) {
/*  409 */         return xWPFComment;
/*      */       }
/*      */     } 
/*  412 */     return null;
/*      */   }
/*      */   
/*      */   public XWPFComment[] getComments() {
/*  416 */     return this.comments.<XWPFComment>toArray(new XWPFComment[this.comments.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PackagePart getPartById(String paramString) {
/*      */     try {
/*  425 */       PackagePart packagePart = getCorePart();
/*  426 */       return packagePart.getRelatedPart(packagePart.getRelationship(paramString));
/*  427 */     } catch (InvalidFormatException invalidFormatException) {
/*  428 */       throw new IllegalArgumentException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFHeaderFooterPolicy getHeaderFooterPolicy() {
/*  437 */     return this.headerFooterPolicy;
/*      */   }
/*      */   public XWPFHeaderFooterPolicy createHeaderFooterPolicy() {
/*  440 */     if (this.headerFooterPolicy == null) {
/*  441 */       if (!this.ctDocument.getBody().isSetSectPr()) {
/*  442 */         this.ctDocument.getBody().addNewSectPr();
/*      */       }
/*  444 */       this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
/*      */     } 
/*  446 */     return this.headerFooterPolicy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTStyles getStyle() throws XmlException, IOException {
/*      */     PackagePart[] arrayOfPackagePart;
/*      */     try {
/*  456 */       arrayOfPackagePart = getRelatedByType(XWPFRelation.STYLES.getRelation());
/*  457 */     } catch (InvalidFormatException invalidFormatException) {
/*  458 */       throw new IllegalStateException(invalidFormatException);
/*      */     } 
/*  460 */     if (arrayOfPackagePart.length != 1) {
/*  461 */       throw new IllegalStateException("Expecting one Styles document part, but found " + arrayOfPackagePart.length);
/*      */     }
/*      */     
/*  464 */     StylesDocument stylesDocument = StylesDocument.Factory.parse(arrayOfPackagePart[0].getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  465 */     return stylesDocument.getStyles();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
/*  473 */     LinkedList<PackagePart> linkedList = new LinkedList();
/*      */ 
/*      */     
/*  476 */     PackagePart packagePart = getPackagePart();
/*  477 */     for (PackageRelationship packageRelationship : getPackagePart().getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject")) {
/*  478 */       linkedList.add(packagePart.getRelatedPart(packageRelationship));
/*      */     }
/*      */     
/*  481 */     for (PackageRelationship packageRelationship : getPackagePart().getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/package")) {
/*  482 */       linkedList.add(packagePart.getRelatedPart(packageRelationship));
/*      */     }
/*      */     
/*  485 */     return linkedList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getBodyElementSpecificPos(int paramInt, List<? extends IBodyElement> paramList) {
/*  493 */     if (paramList.size() == 0) {
/*  494 */       return -1;
/*      */     }
/*      */     
/*  497 */     if (paramInt >= 0 && paramInt < this.bodyElements.size()) {
/*      */       
/*  499 */       IBodyElement iBodyElement = this.bodyElements.get(paramInt);
/*  500 */       if (iBodyElement.getElementType() != ((IBodyElement)paramList.get(0)).getElementType())
/*      */       {
/*  502 */         return -1;
/*      */       }
/*      */ 
/*      */       
/*  506 */       int i = Math.min(paramInt, paramList.size() - 1);
/*  507 */       for (int j = i; j >= 0; j--) {
/*  508 */         if (paramList.get(j) == iBodyElement) {
/*  509 */           return j;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  515 */     return -1;
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
/*      */   public int getParagraphPos(int paramInt) {
/*  529 */     return getBodyElementSpecificPos(paramInt, (List)this.paragraphs);
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
/*      */   public int getTablePos(int paramInt) {
/*  541 */     return getBodyElementSpecificPos(paramInt, (List)this.tables);
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
/*      */   public XWPFParagraph insertNewParagraph(XmlCursor paramXmlCursor) {
/*  557 */     if (isCursorInBody(paramXmlCursor)) {
/*  558 */       String str1 = CTP.type.getName().getNamespaceURI();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  564 */       String str2 = "p";
/*      */ 
/*      */       
/*  567 */       paramXmlCursor.beginElement(str2, str1);
/*      */       
/*  569 */       paramXmlCursor.toParent();
/*  570 */       CTP cTP = (CTP)paramXmlCursor.getObject();
/*  571 */       XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/*  572 */       XmlObject xmlObject = null;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  577 */       while (!(xmlObject instanceof CTP) && paramXmlCursor.toPrevSibling()) {
/*  578 */         xmlObject = paramXmlCursor.getObject();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  588 */       if (!(xmlObject instanceof CTP) || (CTP)xmlObject == cTP) {
/*  589 */         this.paragraphs.add(0, xWPFParagraph);
/*      */       } else {
/*  591 */         int i = this.paragraphs.indexOf(getParagraph((CTP)xmlObject)) + 1;
/*  592 */         this.paragraphs.add(i, xWPFParagraph);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  599 */       XmlCursor xmlCursor = cTP.newCursor();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  605 */         byte b = 0;
/*  606 */         paramXmlCursor.toCursor(xmlCursor);
/*  607 */         while (paramXmlCursor.toPrevSibling()) {
/*  608 */           xmlObject = paramXmlCursor.getObject();
/*  609 */           if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/*  610 */             b++; 
/*      */         } 
/*  612 */         this.bodyElements.add(b, xWPFParagraph);
/*  613 */         paramXmlCursor.toCursor(xmlCursor);
/*  614 */         paramXmlCursor.toEndToken();
/*  615 */         return xWPFParagraph;
/*      */       } finally {
/*  617 */         xmlCursor.dispose();
/*      */       } 
/*      */     } 
/*  620 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public XWPFTable insertNewTbl(XmlCursor paramXmlCursor) {
/*  625 */     if (isCursorInBody(paramXmlCursor)) {
/*  626 */       String str1 = CTTbl.type.getName().getNamespaceURI();
/*  627 */       String str2 = "tbl";
/*  628 */       paramXmlCursor.beginElement(str2, str1);
/*  629 */       paramXmlCursor.toParent();
/*  630 */       CTTbl cTTbl = (CTTbl)paramXmlCursor.getObject();
/*  631 */       XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
/*  632 */       XmlObject xmlObject = null;
/*  633 */       while (!(xmlObject instanceof CTTbl) && paramXmlCursor.toPrevSibling()) {
/*  634 */         xmlObject = paramXmlCursor.getObject();
/*      */       }
/*  636 */       if (!(xmlObject instanceof CTTbl)) {
/*  637 */         this.tables.add(0, xWPFTable);
/*      */       } else {
/*  639 */         int i = this.tables.indexOf(getTable((CTTbl)xmlObject)) + 1;
/*  640 */         this.tables.add(i, xWPFTable);
/*      */       } 
/*  642 */       byte b = 0;
/*  643 */       XmlCursor xmlCursor = cTTbl.newCursor();
/*      */       try {
/*  645 */         paramXmlCursor.toCursor(xmlCursor);
/*  646 */         while (paramXmlCursor.toPrevSibling()) {
/*  647 */           xmlObject = paramXmlCursor.getObject();
/*  648 */           if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/*  649 */             b++; 
/*      */         } 
/*  651 */         this.bodyElements.add(b, xWPFTable);
/*  652 */         paramXmlCursor.toCursor(xmlCursor);
/*  653 */         paramXmlCursor.toEndToken();
/*  654 */         return xWPFTable;
/*      */       } finally {
/*  656 */         xmlCursor.dispose();
/*      */       } 
/*      */     } 
/*  659 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isCursorInBody(XmlCursor paramXmlCursor) {
/*  668 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/*  669 */     xmlCursor.toParent();
/*  670 */     boolean bool = (xmlCursor.getObject() == this.ctDocument.getBody()) ? true : false;
/*  671 */     xmlCursor.dispose();
/*  672 */     return bool;
/*      */   }
/*      */   
/*      */   private int getPosOfBodyElement(IBodyElement paramIBodyElement) {
/*  676 */     BodyElementType bodyElementType = paramIBodyElement.getElementType();
/*      */     
/*  678 */     for (byte b = 0; b < this.bodyElements.size(); b++) {
/*  679 */       IBodyElement iBodyElement = this.bodyElements.get(b);
/*  680 */       if (iBodyElement.getElementType() == bodyElementType && 
/*  681 */         iBodyElement.equals(paramIBodyElement)) {
/*  682 */         return b;
/*      */       }
/*      */     } 
/*      */     
/*  686 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPosOfParagraph(XWPFParagraph paramXWPFParagraph) {
/*  697 */     return getPosOfBodyElement(paramXWPFParagraph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPosOfTable(XWPFTable paramXWPFTable) {
/*  708 */     return getPosOfBodyElement(paramXWPFTable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void commit() throws IOException {
/*  716 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  717 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTDocument1.type.getName().getNamespaceURI(), "document"));
/*      */     
/*  719 */     PackagePart packagePart = getPackagePart();
/*  720 */     OutputStream outputStream = packagePart.getOutputStream();
/*  721 */     this.ctDocument.save(outputStream, xmlOptions);
/*  722 */     outputStream.close();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getRelationIndex(XWPFRelation paramXWPFRelation) {
/*  732 */     byte b = 1;
/*  733 */     for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  734 */       if (relationPart.getRelationship().getRelationshipType().equals(paramXWPFRelation.getRelation())) {
/*  735 */         b++;
/*      */       }
/*      */     } 
/*  738 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFParagraph createParagraph() {
/*  747 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctDocument.getBody().addNewP(), this);
/*  748 */     this.bodyElements.add(xWPFParagraph);
/*  749 */     this.paragraphs.add(xWPFParagraph);
/*  750 */     return xWPFParagraph;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFNumbering createNumbering() {
/*  759 */     if (this.numbering == null) {
/*  760 */       NumberingDocument numberingDocument = NumberingDocument.Factory.newInstance();
/*      */       
/*  762 */       XWPFRelation xWPFRelation = XWPFRelation.NUMBERING;
/*  763 */       int i = getRelationIndex(xWPFRelation);
/*      */       
/*  765 */       XWPFNumbering xWPFNumbering = (XWPFNumbering)createRelationship(xWPFRelation, XWPFFactory.getInstance(), i);
/*  766 */       xWPFNumbering.setNumbering(numberingDocument.addNewNumbering());
/*  767 */       this.numbering = xWPFNumbering;
/*      */     } 
/*      */     
/*  770 */     return this.numbering;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFStyles createStyles() {
/*  779 */     if (this.styles == null) {
/*  780 */       StylesDocument stylesDocument = StylesDocument.Factory.newInstance();
/*      */       
/*  782 */       XWPFRelation xWPFRelation = XWPFRelation.STYLES;
/*  783 */       int i = getRelationIndex(xWPFRelation);
/*      */       
/*  785 */       XWPFStyles xWPFStyles = (XWPFStyles)createRelationship(xWPFRelation, XWPFFactory.getInstance(), i);
/*  786 */       xWPFStyles.setStyles(stylesDocument.addNewStyles());
/*  787 */       this.styles = xWPFStyles;
/*      */     } 
/*      */     
/*  790 */     return this.styles;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFFootnotes createFootnotes() {
/*  799 */     if (this.footnotes == null) {
/*  800 */       FootnotesDocument footnotesDocument = FootnotesDocument.Factory.newInstance();
/*      */       
/*  802 */       XWPFRelation xWPFRelation = XWPFRelation.FOOTNOTE;
/*  803 */       int i = getRelationIndex(xWPFRelation);
/*      */       
/*  805 */       XWPFFootnotes xWPFFootnotes = (XWPFFootnotes)createRelationship(xWPFRelation, XWPFFactory.getInstance(), i);
/*  806 */       xWPFFootnotes.setFootnotes(footnotesDocument.addNewFootnotes());
/*  807 */       this.footnotes = xWPFFootnotes;
/*      */     } 
/*      */     
/*  810 */     return this.footnotes;
/*      */   }
/*      */   
/*      */   public XWPFFootnote addFootnote(CTFtnEdn paramCTFtnEdn) {
/*  814 */     return this.footnotes.addFootnote(paramCTFtnEdn);
/*      */   }
/*      */   
/*      */   public XWPFFootnote addEndnote(CTFtnEdn paramCTFtnEdn) {
/*  818 */     XWPFFootnote xWPFFootnote = new XWPFFootnote(this, paramCTFtnEdn);
/*  819 */     this.endnotes.put(Integer.valueOf(paramCTFtnEdn.getId().intValue()), xWPFFootnote);
/*  820 */     return xWPFFootnote;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeBodyElement(int paramInt) {
/*  830 */     if (paramInt >= 0 && paramInt < this.bodyElements.size()) {
/*  831 */       BodyElementType bodyElementType = ((IBodyElement)this.bodyElements.get(paramInt)).getElementType();
/*  832 */       if (bodyElementType == BodyElementType.TABLE) {
/*  833 */         int i = getTablePos(paramInt);
/*  834 */         this.tables.remove(i);
/*  835 */         this.ctDocument.getBody().removeTbl(i);
/*      */       } 
/*  837 */       if (bodyElementType == BodyElementType.PARAGRAPH) {
/*  838 */         int i = getParagraphPos(paramInt);
/*  839 */         this.paragraphs.remove(i);
/*  840 */         this.ctDocument.getBody().removeP(i);
/*      */       } 
/*  842 */       this.bodyElements.remove(paramInt);
/*  843 */       return true;
/*      */     } 
/*  845 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParagraph(XWPFParagraph paramXWPFParagraph, int paramInt) {
/*  855 */     this.paragraphs.set(paramInt, paramXWPFParagraph);
/*  856 */     this.ctDocument.getBody().setPArray(paramInt, paramXWPFParagraph.getCTP());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFParagraph getLastParagraph() {
/*  867 */     int i = (this.paragraphs.toArray()).length - 1;
/*  868 */     return this.paragraphs.get(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFTable createTable() {
/*  877 */     XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this);
/*  878 */     this.bodyElements.add(xWPFTable);
/*  879 */     this.tables.add(xWPFTable);
/*  880 */     return xWPFTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFTable createTable(int paramInt1, int paramInt2) {
/*  891 */     XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this, paramInt1, paramInt2);
/*  892 */     this.bodyElements.add(xWPFTable);
/*  893 */     this.tables.add(xWPFTable);
/*  894 */     return xWPFTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void createTOC() {
/*  901 */     CTSdtBlock cTSdtBlock = getDocument().getBody().addNewSdt();
/*  902 */     TOC tOC = new TOC(cTSdtBlock);
/*  903 */     for (XWPFParagraph xWPFParagraph : this.paragraphs) {
/*  904 */       String str = xWPFParagraph.getStyle();
/*  905 */       if (str != null && str.startsWith("Heading")) {
/*      */         try {
/*  907 */           int i = Integer.parseInt(str.substring("Heading".length()));
/*  908 */           tOC.addRow(i, xWPFParagraph.getText(), 1, "112723803");
/*  909 */         } catch (NumberFormatException numberFormatException) {
/*  910 */           LOG.log(7, new Object[] { "can't format number in TOC heading", numberFormatException });
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTable(int paramInt, XWPFTable paramXWPFTable) {
/*  923 */     this.tables.set(paramInt, paramXWPFTable);
/*  924 */     this.ctDocument.getBody().setTblArray(paramInt, paramXWPFTable.getCTTbl());
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
/*      */   public boolean isEnforcedProtection() {
/*  940 */     return this.settings.isEnforcedWith();
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
/*      */   public boolean isEnforcedReadonlyProtection() {
/*  957 */     return this.settings.isEnforcedWith(STDocProtect.READ_ONLY);
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
/*      */   public boolean isEnforcedFillingFormsProtection() {
/*  974 */     return this.settings.isEnforcedWith(STDocProtect.FORMS);
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
/*      */   public boolean isEnforcedCommentsProtection() {
/*  991 */     return this.settings.isEnforcedWith(STDocProtect.COMMENTS);
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
/*      */   public boolean isEnforcedTrackedChangesProtection() {
/* 1008 */     return this.settings.isEnforcedWith(STDocProtect.TRACKED_CHANGES);
/*      */   }
/*      */   
/*      */   public boolean isEnforcedUpdateFields() {
/* 1012 */     return this.settings.isUpdateFields();
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
/*      */   public void enforceReadonlyProtection() {
/* 1028 */     this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY);
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
/*      */   public void enforceReadonlyProtection(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 1048 */     this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY, paramString, paramHashAlgorithm);
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
/*      */   public void enforceFillingFormsProtection() {
/* 1064 */     this.settings.setEnforcementEditValue(STDocProtect.FORMS);
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
/*      */   public void enforceFillingFormsProtection(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 1084 */     this.settings.setEnforcementEditValue(STDocProtect.FORMS, paramString, paramHashAlgorithm);
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
/*      */   public void enforceCommentsProtection() {
/* 1100 */     this.settings.setEnforcementEditValue(STDocProtect.COMMENTS);
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
/*      */   public void enforceCommentsProtection(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 1120 */     this.settings.setEnforcementEditValue(STDocProtect.COMMENTS, paramString, paramHashAlgorithm);
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
/*      */   public void enforceTrackedChangesProtection() {
/* 1136 */     this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES);
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
/*      */   public void enforceTrackedChangesProtection(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 1156 */     this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES, paramString, paramHashAlgorithm);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean validateProtectionPassword(String paramString) {
/* 1166 */     return this.settings.validateProtectionPassword(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeProtectionEnforcement() {
/* 1175 */     this.settings.removeEnforcement();
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
/*      */   public void enforceUpdateFields() {
/* 1191 */     this.settings.setUpdateFields();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isTrackRevisions() {
/* 1200 */     return this.settings.isTrackRevisions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTrackRevisions(boolean paramBoolean) {
/* 1209 */     this.settings.setTrackRevisions(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getZoomPercent() {
/* 1219 */     return this.settings.getZoomPercent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setZoomPercent(long paramLong) {
/* 1228 */     this.settings.setZoomPercent(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertTable(int paramInt, XWPFTable paramXWPFTable) {
/* 1239 */     this.bodyElements.add(paramInt, paramXWPFTable);
/* 1240 */     byte b = 0;
/* 1241 */     for (CTTbl cTTbl : this.ctDocument.getBody().getTblArray()) {
/* 1242 */       if (cTTbl == paramXWPFTable.getCTTbl()) {
/*      */         break;
/*      */       }
/* 1245 */       b++;
/*      */     } 
/* 1247 */     this.tables.add(b, paramXWPFTable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFPictureData> getAllPictures() {
/* 1256 */     return Collections.unmodifiableList(this.pictures);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFPictureData> getAllPackagePictures() {
/* 1263 */     ArrayList<? extends XWPFPictureData> arrayList = new ArrayList();
/* 1264 */     Collection<List<XWPFPictureData>> collection = this.packagePictures.values();
/* 1265 */     for (List<XWPFPictureData> list : collection) {
/* 1266 */       arrayList.addAll(list);
/*      */     }
/* 1268 */     return Collections.unmodifiableList(arrayList);
/*      */   }
/*      */   
/*      */   void registerPackagePictureData(XWPFPictureData paramXWPFPictureData) {
/* 1272 */     List<XWPFPictureData> list = this.packagePictures.get(paramXWPFPictureData.getChecksum());
/* 1273 */     if (list == null) {
/* 1274 */       list = new ArrayList(1);
/* 1275 */       this.packagePictures.put(paramXWPFPictureData.getChecksum(), list);
/*      */     } 
/* 1277 */     if (!list.contains(paramXWPFPictureData)) {
/* 1278 */       list.add(paramXWPFPictureData);
/*      */     }
/*      */   }
/*      */   
/*      */   XWPFPictureData findPackagePictureData(byte[] paramArrayOfbyte, int paramInt) {
/* 1283 */     long l = IOUtils.calculateChecksum(paramArrayOfbyte);
/* 1284 */     XWPFPictureData xWPFPictureData = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1289 */     List list = this.packagePictures.get(Long.valueOf(l));
/* 1290 */     if (list != null) {
/* 1291 */       Iterator<XWPFPictureData> iterator = list.iterator();
/* 1292 */       while (iterator.hasNext() && xWPFPictureData == null) {
/* 1293 */         XWPFPictureData xWPFPictureData1 = iterator.next();
/* 1294 */         if (Arrays.equals(paramArrayOfbyte, xWPFPictureData1.getData())) {
/* 1295 */           xWPFPictureData = xWPFPictureData1;
/*      */         }
/*      */       } 
/*      */     } 
/* 1299 */     return xWPFPictureData;
/*      */   }
/*      */   
/*      */   public String addPictureData(byte[] paramArrayOfbyte, int paramInt) throws InvalidFormatException {
/* 1303 */     XWPFPictureData xWPFPictureData = findPackagePictureData(paramArrayOfbyte, paramInt);
/* 1304 */     POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[paramInt];
/*      */     
/* 1306 */     if (xWPFPictureData == null) {
/*      */       
/* 1308 */       int i = getNextPicNameNumber(paramInt);
/* 1309 */       xWPFPictureData = (XWPFPictureData)createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), i);
/*      */       
/* 1311 */       PackagePart packagePart = xWPFPictureData.getPackagePart();
/* 1312 */       OutputStream outputStream = null;
/*      */       try {
/* 1314 */         outputStream = packagePart.getOutputStream();
/* 1315 */         outputStream.write(paramArrayOfbyte);
/* 1316 */       } catch (IOException iOException) {
/* 1317 */         throw new POIXMLException(iOException);
/*      */       } finally {
/*      */         try {
/* 1320 */           if (outputStream != null) outputStream.close(); 
/* 1321 */         } catch (IOException iOException) {}
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1326 */       registerPackagePictureData(xWPFPictureData);
/* 1327 */       this.pictures.add(xWPFPictureData);
/*      */       
/* 1329 */       return getRelationId(xWPFPictureData);
/* 1330 */     }  if (!getRelations().contains(xWPFPictureData)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1337 */       POIXMLDocumentPart.RelationPart relationPart = addRelation(null, XWPFRelation.IMAGES, xWPFPictureData);
/* 1338 */       return relationPart.getRelationship().getId();
/*      */     } 
/*      */     
/* 1341 */     return getRelationId(xWPFPictureData);
/*      */   }
/*      */ 
/*      */   
/*      */   public String addPictureData(InputStream paramInputStream, int paramInt) throws InvalidFormatException {
/*      */     try {
/* 1347 */       byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
/* 1348 */       return addPictureData(arrayOfByte, paramInt);
/* 1349 */     } catch (IOException iOException) {
/* 1350 */       throw new POIXMLException(iOException);
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
/*      */   public int getNextPicNameNumber(int paramInt) throws InvalidFormatException {
/* 1362 */     int i = getAllPackagePictures().size() + 1;
/* 1363 */     String str = XWPFPictureData.RELATIONS[paramInt].getFileName(i);
/* 1364 */     PackagePartName packagePartName = PackagingURIHelper.createPartName(str);
/* 1365 */     while (getPackage().getPart(packagePartName) != null) {
/* 1366 */       i++;
/* 1367 */       str = XWPFPictureData.RELATIONS[paramInt].getFileName(i);
/* 1368 */       packagePartName = PackagingURIHelper.createPartName(str);
/*      */     } 
/* 1370 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFPictureData getPictureDataByID(String paramString) {
/* 1380 */     POIXMLDocumentPart pOIXMLDocumentPart = getRelationById(paramString);
/* 1381 */     if (pOIXMLDocumentPart instanceof XWPFPictureData) {
/* 1382 */       return (XWPFPictureData)pOIXMLDocumentPart;
/*      */     }
/*      */     
/* 1385 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFNumbering getNumbering() {
/* 1394 */     return this.numbering;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFStyles getStyles() {
/* 1403 */     return this.styles;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFParagraph getParagraph(CTP paramCTP) {
/* 1414 */     for (byte b = 0; b < getParagraphs().size(); b++) {
/* 1415 */       if (((XWPFParagraph)getParagraphs().get(b)).getCTP() == paramCTP) {
/* 1416 */         return getParagraphs().get(b);
/*      */       }
/*      */     } 
/* 1419 */     return null;
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
/*      */   public XWPFTable getTable(CTTbl paramCTTbl) {
/* 1431 */     for (byte b = 0; b < this.tables.size(); b++) {
/* 1432 */       if (((XWPFTable)getTables().get(b)).getCTTbl() == paramCTTbl) {
/* 1433 */         return getTables().get(b);
/*      */       }
/*      */     } 
/* 1436 */     return null;
/*      */   }
/*      */   
/*      */   public Iterator<XWPFTable> getTablesIterator() {
/* 1440 */     return this.tables.iterator();
/*      */   }
/*      */   
/*      */   public Iterator<XWPFParagraph> getParagraphsIterator() {
/* 1444 */     return this.paragraphs.iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFParagraph getParagraphArray(int paramInt) {
/* 1454 */     if (paramInt >= 0 && paramInt < this.paragraphs.size()) {
/* 1455 */       return this.paragraphs.get(paramInt);
/*      */     }
/* 1457 */     return null;
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
/*      */   public POIXMLDocumentPart getPart() {
/* 1469 */     return (POIXMLDocumentPart)this;
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
/*      */   public BodyType getPartType() {
/* 1481 */     return BodyType.DOCUMENT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFTableCell getTableCell(CTTc paramCTTc) {
/* 1491 */     XmlCursor xmlCursor = paramCTTc.newCursor();
/* 1492 */     xmlCursor.toParent();
/* 1493 */     XmlObject xmlObject = xmlCursor.getObject();
/* 1494 */     if (!(xmlObject instanceof CTRow)) {
/* 1495 */       return null;
/*      */     }
/* 1497 */     CTRow cTRow = (CTRow)xmlObject;
/* 1498 */     xmlCursor.toParent();
/* 1499 */     xmlObject = xmlCursor.getObject();
/* 1500 */     xmlCursor.dispose();
/* 1501 */     if (!(xmlObject instanceof CTTbl)) {
/* 1502 */       return null;
/*      */     }
/* 1504 */     CTTbl cTTbl = (CTTbl)xmlObject;
/* 1505 */     XWPFTable xWPFTable = getTable(cTTbl);
/* 1506 */     if (xWPFTable == null) {
/* 1507 */       return null;
/*      */     }
/* 1509 */     XWPFTableRow xWPFTableRow = xWPFTable.getRow(cTRow);
/* 1510 */     if (xWPFTableRow == null) {
/* 1511 */       return null;
/*      */     }
/* 1513 */     return xWPFTableRow.getTableCell(paramCTTc);
/*      */   }
/*      */ 
/*      */   
/*      */   public XWPFDocument getXWPFDocument() {
/* 1518 */     return this;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */