                  /*  File:  pendulum2.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class pendulum2 extends Template {

     static {templateClass = new pendulum2() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "pendulum2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;   // in inches
          ysize = 2.1 ;   // in inches
          xmin = -50 ;
          xmax = 50 ;
          ymin = -100 ;
          ymax = 50 ;
          topmargin = -0.45 ;   // in inches
          bottommargin = -0.4 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fLine(0, 0, 25, -50) ;
          fEnv("psFillGray", 0.7) ; 
          fDisk(25, -50, 5, 5, FILLED) ;
          fEnv("psFillGray", 0.0) ; 
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, 0, -25) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fTeXlabel(5, -17, "tc", "$\\theta$") ;
          fTeXlabel(16*0.8+1, -25*0.8, "lc", "$\\ell$") ;
          fArrow( 25, -50, 25, -72) ; 
          fTeXlabel(25, -74, "tc", "$mg$") ;
          fArrow( 25, -50, 16, -32) ;
          fTeXlabel(16, -35, "tr", "$\\tau$") ;
          fArrow(25, -50, 43, -41) ;
          fTeXlabel(42, -42, "bl", "$-\\beta\\ell\\diff{\\theta}{t}$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          
          fEnv("lineWidth", 2.0) ;
          fLine(-20, 0, 20, 0) ;
          fEnv("lineWidth", 0.4) ;
          canvas.append( new fPsWrite("newpath 30 72 moveto 70 72 lineto 70 81 lineto 30 81 lineto closepath clip ") ) ;
          for(double xx=-20 ; xx < 40.1 ; xx += 4) {
               fLine(xx,0, xx-50, xx+50) ;
          }
     }
}
