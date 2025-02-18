/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue(){
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("fishhead.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testNegate(){
    Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.negate();
    fish.explore();
  }

  public static void testGrayscale(){
    Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.grayscale();
    fish.explore();
  }
  public static void testMirrorVerticalRightToLeft(){
     Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.mirrorVerticalRightToLeft();
    fish.explore();
  }
  
  public static void testMirrorHorizontal(){
     Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.mirrorHorizontal();
    fish.explore();
  }

  public static void testMirrorHorizontalBotToTop(){
     Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.mirrorHorizontalBotToTop();
    fish.explore();
  }

   public static void testMirrorDiagonal(){
     Picture fish = new Picture("fishhead.jpg");
    fish.explore();
    fish.mirrorDiagonal();
    fish.explore();
  }

  public static void testMirrorArms(){
     Picture snow = new Picture("snowman.jpg");
    snow.explore();
    snow.mirrorArms();
    snow.explore();
  }

  public static void testMirrorGull(){
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }

  public static void testCopy(){
    Picture a = new Picture("seagull.jpg");
    a.explore();
    a.createCollage();
    a.explore();
    Picture b = new Picture("fishhead.jpg");
    a.copy(b, 0, 100, 0, 500);
    a.explore();
  }

  public static void testSuperCollage(){
    Picture a1 = new Picture("7inX95in.jpg");
    a1.explore();
    a1.createSuperCollage();
    a1.explore();
  }
  
  public static void testEdgeDetection2(){
    Picture b = new Picture("fishhead.jpg");
    b.explore();
    b.edgeDetection2(30);
    b.explore();
  }

  public static testFixUnderwater(){
    Picture b = new Picture("water..jpg");
    b.explore();
    b.fixUnderwater();
    b.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testSuperCollage();
    // testZeroBlue();
    // testKeepOnlyBlue();
    // testKeepOnlyRed();
    // testKeepOnlyGreen();
    // testNegate();
    // testGrayscale();
    //testFixUnderwater();
    // testMirrorVertical();
    // testMirrorVerticalRightToLeft();
    // testMirrorHorizontal();
    // testMirrorHorizontalBotToTop();
    // testMirrorTemple();
    // testMirrorArms();
    // testMirrorGull();
    // testMirrorDiagonal();
    //testCollage();
    // testCopy();
    // testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}