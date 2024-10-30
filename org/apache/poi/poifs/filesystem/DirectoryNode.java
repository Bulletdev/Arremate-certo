/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.hpsf.ClassID;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.poifs.property.DirectoryProperty;
/*     */ import org.apache.poi.poifs.property.DocumentProperty;
/*     */ import org.apache.poi.poifs.property.Property;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DirectoryNode
/*     */   extends EntryNode
/*     */   implements Iterable<Entry>, POIFSViewable, DirectoryEntry
/*     */ {
/*     */   private Map<String, Entry> _byname;
/*     */   private ArrayList<Entry> _entries;
/*     */   private OPOIFSFileSystem _ofilesystem;
/*     */   private NPOIFSFileSystem _nfilesystem;
/*     */   private POIFSDocumentPath _path;
/*     */   
/*     */   DirectoryNode(DirectoryProperty paramDirectoryProperty, OPOIFSFileSystem paramOPOIFSFileSystem, DirectoryNode paramDirectoryNode) {
/*  72 */     this(paramDirectoryProperty, paramDirectoryNode, paramOPOIFSFileSystem, (NPOIFSFileSystem)null);
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
/*     */   DirectoryNode(DirectoryProperty paramDirectoryProperty, NPOIFSFileSystem paramNPOIFSFileSystem, DirectoryNode paramDirectoryNode) {
/*  87 */     this(paramDirectoryProperty, paramDirectoryNode, (OPOIFSFileSystem)null, paramNPOIFSFileSystem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DirectoryNode(DirectoryProperty paramDirectoryProperty, DirectoryNode paramDirectoryNode, OPOIFSFileSystem paramOPOIFSFileSystem, NPOIFSFileSystem paramNPOIFSFileSystem) {
/*  95 */     super((Property)paramDirectoryProperty, paramDirectoryNode);
/*  96 */     this._ofilesystem = paramOPOIFSFileSystem;
/*  97 */     this._nfilesystem = paramNPOIFSFileSystem;
/*     */     
/*  99 */     if (paramDirectoryNode == null) {
/*     */       
/* 101 */       this._path = new POIFSDocumentPath();
/*     */     }
/*     */     else {
/*     */       
/* 105 */       this._path = new POIFSDocumentPath(paramDirectoryNode._path, new String[] { paramDirectoryProperty.getName() });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 110 */     this._byname = new HashMap<String, Entry>();
/* 111 */     this._entries = new ArrayList<Entry>();
/* 112 */     Iterator<Property> iterator = paramDirectoryProperty.getChildren();
/*     */     
/* 114 */     while (iterator.hasNext()) {
/*     */       DocumentNode documentNode;
/* 116 */       Property property = iterator.next();
/* 117 */       DirectoryNode directoryNode = null;
/*     */       
/* 119 */       if (property.isDirectory()) {
/*     */         
/* 121 */         DirectoryProperty directoryProperty = (DirectoryProperty)property;
/* 122 */         if (this._ofilesystem != null) {
/* 123 */           directoryNode = new DirectoryNode(directoryProperty, this._ofilesystem, this);
/*     */         } else {
/* 125 */           directoryNode = new DirectoryNode(directoryProperty, this._nfilesystem, this);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 130 */         documentNode = new DocumentNode((DocumentProperty)property, this);
/*     */       } 
/* 132 */       this._entries.add(documentNode);
/* 133 */       this._byname.put(documentNode.getName(), documentNode);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIFSDocumentPath getPath() {
/* 143 */     return this._path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NPOIFSFileSystem getFileSystem() {
/* 151 */     return this._nfilesystem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSFileSystem getOFileSystem() {
/* 161 */     return this._ofilesystem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NPOIFSFileSystem getNFileSystem() {
/* 171 */     return this._nfilesystem;
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
/*     */   public DocumentInputStream createDocumentInputStream(String paramString) throws IOException {
/* 188 */     return createDocumentInputStream(getEntry(paramString));
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
/*     */   public DocumentInputStream createDocumentInputStream(Entry paramEntry) throws IOException {
/* 205 */     if (!paramEntry.isDocumentEntry()) {
/* 206 */       throw new IOException("Entry '" + paramEntry.getName() + "' is not a DocumentEntry");
/*     */     }
/*     */ 
/*     */     
/* 210 */     DocumentEntry documentEntry = (DocumentEntry)paramEntry;
/* 211 */     return new DocumentInputStream(documentEntry);
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
/*     */   DocumentEntry createDocument(OPOIFSDocument paramOPOIFSDocument) throws IOException {
/* 226 */     DocumentProperty documentProperty = paramOPOIFSDocument.getDocumentProperty();
/* 227 */     DocumentNode documentNode = new DocumentNode(documentProperty, this);
/*     */     
/* 229 */     ((DirectoryProperty)getProperty()).addChild((Property)documentProperty);
/* 230 */     this._ofilesystem.addDocument(paramOPOIFSDocument);
/*     */     
/* 232 */     this._entries.add(documentNode);
/* 233 */     this._byname.put(documentProperty.getName(), documentNode);
/* 234 */     return documentNode;
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
/*     */   DocumentEntry createDocument(NPOIFSDocument paramNPOIFSDocument) throws IOException {
/* 249 */     DocumentProperty documentProperty = paramNPOIFSDocument.getDocumentProperty();
/* 250 */     DocumentNode documentNode = new DocumentNode(documentProperty, this);
/*     */     
/* 252 */     ((DirectoryProperty)getProperty()).addChild((Property)documentProperty);
/* 253 */     this._nfilesystem.addDocument(paramNPOIFSDocument);
/*     */     
/* 255 */     this._entries.add(documentNode);
/* 256 */     this._byname.put(documentProperty.getName(), documentNode);
/* 257 */     return documentNode;
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
/*     */   boolean changeName(String paramString1, String paramString2) {
/* 270 */     boolean bool = false;
/* 271 */     EntryNode entryNode = (EntryNode)this._byname.get(paramString1);
/*     */     
/* 273 */     if (entryNode != null) {
/*     */       
/* 275 */       bool = ((DirectoryProperty)getProperty()).changeName(entryNode.getProperty(), paramString2);
/*     */       
/* 277 */       if (bool) {
/*     */         
/* 279 */         this._byname.remove(paramString1);
/* 280 */         this._byname.put(entryNode.getProperty().getName(), entryNode);
/*     */       } 
/*     */     } 
/* 283 */     return bool;
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
/*     */   boolean deleteEntry(EntryNode paramEntryNode) {
/* 296 */     boolean bool = ((DirectoryProperty)getProperty()).deleteChild(paramEntryNode.getProperty());
/*     */ 
/*     */ 
/*     */     
/* 300 */     if (bool) {
/*     */       
/* 302 */       this._entries.remove(paramEntryNode);
/* 303 */       this._byname.remove(paramEntryNode.getName());
/*     */       
/* 305 */       if (this._ofilesystem != null) {
/* 306 */         this._ofilesystem.remove(paramEntryNode);
/*     */       } else {
/*     */         try {
/* 309 */           this._nfilesystem.remove(paramEntryNode);
/* 310 */         } catch (IOException iOException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 315 */     return bool;
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
/*     */   public Iterator<Entry> getEntries() {
/* 333 */     return this._entries.iterator();
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
/*     */   public Set<String> getEntryNames() {
/* 347 */     return this._byname.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 358 */     return this._entries.isEmpty();
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
/*     */   public int getEntryCount() {
/* 371 */     return this._entries.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEntry(String paramString) {
/* 376 */     return (paramString != null && this._byname.containsKey(paramString));
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
/*     */   public Entry getEntry(String paramString) throws FileNotFoundException {
/* 392 */     Entry entry = null;
/*     */     
/* 394 */     if (paramString != null) {
/* 395 */       entry = this._byname.get(paramString);
/*     */     }
/* 397 */     if (entry == null)
/*     */     {
/* 399 */       throw new FileNotFoundException("no such entry: \"" + paramString + "\", had: " + this._byname.keySet());
/*     */     }
/*     */     
/* 402 */     return entry;
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
/*     */   
/*     */   public DocumentEntry createDocument(String paramString, InputStream paramInputStream) throws IOException {
/* 421 */     if (this._nfilesystem != null) {
/* 422 */       return createDocument(new NPOIFSDocument(paramString, this._nfilesystem, paramInputStream));
/*     */     }
/* 424 */     return createDocument(new OPOIFSDocument(paramString, paramInputStream));
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
/*     */ 
/*     */   
/*     */   public DocumentEntry createDocument(String paramString, int paramInt, POIFSWriterListener paramPOIFSWriterListener) throws IOException {
/* 444 */     if (this._nfilesystem != null) {
/* 445 */       return createDocument(new NPOIFSDocument(paramString, paramInt, this._nfilesystem, paramPOIFSWriterListener));
/*     */     }
/* 447 */     return createDocument(new OPOIFSDocument(paramString, paramInt, this._path, paramPOIFSWriterListener));
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
/*     */   public DirectoryEntry createDirectory(String paramString) throws IOException {
/*     */     DirectoryNode directoryNode;
/* 465 */     DirectoryProperty directoryProperty = new DirectoryProperty(paramString);
/*     */     
/* 467 */     if (this._ofilesystem != null) {
/* 468 */       directoryNode = new DirectoryNode(directoryProperty, this._ofilesystem, this);
/* 469 */       this._ofilesystem.addDirectory(directoryProperty);
/*     */     } else {
/* 471 */       directoryNode = new DirectoryNode(directoryProperty, this._nfilesystem, this);
/* 472 */       this._nfilesystem.addDirectory(directoryProperty);
/*     */     } 
/*     */     
/* 475 */     ((DirectoryProperty)getProperty()).addChild((Property)directoryProperty);
/* 476 */     this._entries.add(directoryNode);
/* 477 */     this._byname.put(paramString, directoryNode);
/* 478 */     return directoryNode;
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
/*     */   
/*     */   public DocumentEntry createOrUpdateDocument(String paramString, InputStream paramInputStream) throws IOException {
/* 497 */     if (!hasEntry(paramString)) {
/* 498 */       return createDocument(paramString, paramInputStream);
/*     */     }
/* 500 */     DocumentNode documentNode = (DocumentNode)getEntry(paramString);
/* 501 */     if (this._nfilesystem != null) {
/* 502 */       NPOIFSDocument nPOIFSDocument = new NPOIFSDocument(documentNode);
/* 503 */       nPOIFSDocument.replaceContents(paramInputStream);
/* 504 */       return documentNode;
/*     */     } 
/*     */     
/* 507 */     deleteEntry(documentNode);
/* 508 */     return createDocument(paramString, paramInputStream);
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
/*     */   public ClassID getStorageClsid() {
/* 520 */     return getProperty().getStorageClsid();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStorageClsid(ClassID paramClassID) {
/* 530 */     getProperty().setStorageClsid(paramClassID);
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
/*     */   public boolean isDirectoryEntry() {
/* 545 */     return true;
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
/*     */   
/*     */   protected boolean isDeleteOK() {
/* 564 */     return isEmpty();
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
/*     */   public Object[] getViewableArray() {
/* 579 */     return new Object[0];
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
/*     */   public Iterator<Object> getViewableIterator() {
/* 591 */     ArrayList<Property> arrayList = new ArrayList();
/*     */     
/* 593 */     arrayList.add(getProperty());
/* 594 */     Iterator<Entry> iterator = this._entries.iterator();
/* 595 */     while (iterator.hasNext())
/*     */     {
/* 597 */       arrayList.add((Property)iterator.next());
/*     */     }
/* 599 */     return arrayList.iterator();
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
/*     */   public boolean preferArray() {
/* 612 */     return false;
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
/*     */   public String getShortDescription() {
/* 624 */     return getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Entry> iterator() {
/* 631 */     return getEntries();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\DirectoryNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */