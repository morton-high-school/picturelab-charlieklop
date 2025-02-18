import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray : pixels){
      for(Pixel pixelObj : rowArray){
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width / 2; col > 0 ; col--)
      {
        leftPixel = pixels[row][width - col - 1];
        rightPixel = pixels[row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorHorizontal(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels.length;
    for(int col = 0; col < pixels[0].length; col++){
        for(int row = 0; row < pixels.length; row++){
          topPixel = pixels[row][col];
          bottomPixel = pixels[width - row -1][col];
          topPixel.setColor(bottomPixel.getColor());
        }
    }
  }

  public void mirrorHorizontalBotToTop(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels.length;
    for(int col = 0; col < pixels[0].length; col++){
        for(int row = 0; row < pixels.length; row++){
          topPixel = pixels[width - row -1][col];
          bottomPixel = pixels[row][col];
          topPixel.setColor(bottomPixel.getColor());
        }
    }
  }

  public void mirrorDiagonal(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel lPixel = null;
    Pixel rPixel = null;
    for(int row = 0; row<pixels.length; row++){
      for(int col = 0; col <pixels.length; col++){
        lPixel = pixels[row][col];
        rPixel = pixels[col][row];
        rPixel.setColor(lPixel.getColor());
      }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    int count = 0;
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int endRow, int startCol, int endColumn)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < endRow &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < endColumn &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

   public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void createSuperCollage(){
    Picture a1 = new Picture("fishhead.jpg");
    Picture a2 = new Picture("beach.jpg");
    this.copy(a1, 100, 100);
    this.copy(a2, 200, 200);
    Picture a3 = new Picture(a1);
    a3.mirrorDiagonal();
    a3.zeroBlue();
    this.copy(a3, 0,0);
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    Pixel topPixel = null;
    Pixel botPixel = null;
    Color botColor = null;
    for(int row=0; row<pixels.length-1; row++){
      for(int col=0; col<pixels[0].length; col++){
        topPixel = pixels[row][col];
        botPixel = pixels[row+1][col];
        botColor = botPixel.getColor();
        if(topPixel.colorDistance(botColor) > edgeDist){
          topPixel.setColor(Color.BLACK);
        }else{
          topPixel.setColor(Color.WHITE);
        }
      }
    }
  }

  public void negate(){
     Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray : pixels){
      for(Pixel pixelObj : rowArray){
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }

  public void grayscale(){
     Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray : pixels){
      for(Pixel pixelObj : rowArray){
        int avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
      }
    }
  }

  public void fixUnderwater(){
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray : pixels){
      for(Pixel pixelObj : rowArray){
        if(pixelObj.getBlue()>=165){
          pixelObj.setRed(pixelObj.getRed()+50);
          pixelObj.setGreen(pixelObj.getGreen()+50);
        }
      }
    }
  }

  public void mirrorArms(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel lPixel = null;
    Pixel rPixel = null;
    int mirrorPoint = 193;
    for(int row=157; row<=193; row++){
      for(int col = 105; col<=171; col++){
        lPixel = pixels[row][col];
        rPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        rPixel.setColor(lPixel.getColor());
      }
    }
    for(int row=169; row<=203; row++){
      for(int col = 235; col<=299; col++){
        lPixel = pixels[row][col];
        rPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        rPixel.setColor(lPixel.getColor());
      }
    }
  }

  public void edgeDetection2(int edgeDist){
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color leftColor = null;
    for(int col = pixels[0].length/2; col>0; col--){
      for(int row = 0; row<pixels.length; row++){
        leftPixel = pixels[row][col-1];
        rightPixel = pixels[row][col];
        leftColor = leftPixel.getColor();
        if (rightPixel.colorDistance(leftColor) > edgeDist){
          rightPixel.setColor(Color.BLACK);
        }else{
          rightPixel.setColor(Color.WHITE);
        }
      }
    }
    for(int col = pixels[0].length/2+1; col<pixels[0].length; col++){
      for(int row = 0; row<pixels.length; row++){
        leftPixel = pixels[row][col-1];
        rightPixel = pixels[row][col];
        leftColor = leftPixel.getColor();
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist){
          leftPixel.setColor(Color.BLACK);
        }else{
          leftPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  public void mirrorGull(){
    Pixel[][] pixels = this.getPixels2D();
    Pixel lPixel = null;
    Pixel rPixel = null;
    int mirrorPoint = 345;
    for(int row=232; row<=328; row++){
      for(int col = 235; col<=345; col++){
        lPixel = pixels[row][col];
        rPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rPixel.setColor(lPixel.getColor());
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();

  }
  
} // this } is the end of class Picture, put all new methods before this
