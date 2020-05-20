                  /*  File:  movingParticle.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class movingParticle extends Template {

     static {templateClass = new movingParticle() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "movingParticle" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   // in inches
          ysize = 1.5 ;   // in inches
          xmin = -0.1 ;
          xmax = 1 ;
          ymin = -0.1 ;
          ymax = 1 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0,ymax) ;
          double x = 0.4 ; double y = x*x ;
          double vx = 0.3 ; double vy = 2*x*vx ;
          double xx = 0.8 ; double yy = xx*xx ;
          double vxx = 0.15 ; double vyy = 2*xx*vxx ;
          double r = 0.05 ;
//          fEnv("psFillGray", 0.0) ; 
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fCurve("y=x*x", 0, xmin, xmax, OPEN) ;
          fEnv("psFillGray", 0.6) ; 
          fDisk(x, y, r, r, FILLED) ;
          fDisk(xx, yy, r, r, FILLED) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
          fArrow( x, y, x+vx, y+vy) ; 
          fTeXlabel(x+vx+0.075, y+vy-0.05, "tr", "$\\vv$") ;
          fArrow( xx, yy, xx+vxx, yy+vyy) ; 
          fTeXlabel(xx+vxx+0.09, yy+vyy-0.025, "tr", "$\\vv$") ;
          fTeXlabel(xmax, -0.025, "tr", "$x$") ;
          fTeXlabel(-0.025, ymax, "tr", "$y$") ;
     }
}
