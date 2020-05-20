                  /*  File:  merryB.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class merryB extends Template {

     static {templateClass = new merryB() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "merryB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;   // in inches
          ysize = 1 ;   // in inches
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.9) ; 
          fDisk(0, 0, 1, 1, FILLED+CLOSED) ;
          fEnv("lineWidth", 0.5) ;
          double r = 0.3 ;
          fEllipticalArc(0,0, r,r, -90, -30, OPEN) ;
          double th = -53*Math.PI/180.0 ;
          fTeXlabel(1.35*r*Math.cos(th), 1.35*r*Math.sin(th), "tc", "$\\scriptstyle\\Omega t$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          th = -30*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.2*Math.cos(th), 1.2*Math.sin(th), "cc", "$x$") ;
          th = (-30+90)*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.2*Math.cos(th), 1.2*Math.sin(th), "cc", "$y$") ;
          fTeXlabel(0, -1.4, "tc", "top view") ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          th = -90*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.2*Math.cos(th), 1.2*Math.sin(th), "cc", "$X$") ;
          th = (-90+90)*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.2*Math.cos(th), 1.2*Math.sin(th), "cc", "$Y$") ;
     }
}
