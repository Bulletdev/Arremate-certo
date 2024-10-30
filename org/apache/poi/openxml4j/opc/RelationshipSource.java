package org.apache.poi.openxml4j.opc;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;

public interface RelationshipSource {
  PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString);
  
  PackageRelationship addRelationship(PackagePartName paramPackagePartName, TargetMode paramTargetMode, String paramString1, String paramString2);
  
  PackageRelationship addExternalRelationship(String paramString1, String paramString2);
  
  PackageRelationship addExternalRelationship(String paramString1, String paramString2, String paramString3);
  
  void clearRelationships();
  
  void removeRelationship(String paramString);
  
  PackageRelationshipCollection getRelationships() throws InvalidFormatException, OpenXML4JException;
  
  PackageRelationship getRelationship(String paramString);
  
  PackageRelationshipCollection getRelationshipsByType(String paramString) throws InvalidFormatException, IllegalArgumentException, OpenXML4JException;
  
  boolean hasRelationships();
  
  boolean isRelationshipExists(PackageRelationship paramPackageRelationship);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\RelationshipSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */