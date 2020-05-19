                  /*  File:  merryC.java    */


import figPac.* ;
// import fnPac.* ;
// import java.applet.* ;
// import java.awt.* ;


public class merryC extends Template {

     static {templateClass = new merryC() ; }
     private static final long serialVersionUID = 1234512345123451234L; 

     public void setup() {
          filePrefix = "merryC" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3 ;   // in inches
          ysize = 1.3 ;   // in inches
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
          double r = 0.2 ;
          fEllipticalArc(0,0, r,r, -90, -30, OPEN) ;
          fEllipticalArc(0,0, r,r,  0, 60, OPEN) ;
          double th = -53*Math.PI/180.0 ;
          fTeXlabel(1.35*r*Math.cos(th), 1.35*r*Math.sin(th), "tc", "$\\scriptstyle\\Omega t$") ;
          th = -30*Math.PI/180.0 ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(0, Math.sin(th), Math.cos(th), Math.sin(th)) ;
          th = 47*Math.PI/180.0 ;
          fTeXlabel(1.45*r*Math.cos(th), 1.45*r*Math.sin(th), "tl", "$\\scriptstyle\\Omega t$") ;
          th = (-30+90)*Math.PI/180.0 ;
          fLine(Math.cos(th), 0, Math.cos(th), Math.sin(th)) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          th = -30*Math.PI/180.0 ;
          fArrow(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.36*Math.cos(th), 1.36*Math.sin(th)+0.1, "cc", "$\\hi(t)$") ;
          th = (-30+90)*Math.PI/180.0 ;
          fArrow(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.3*Math.cos(th), 1.3*Math.sin(th), "cc", "$\\hj(t)$") ;
//          fTeXlabel(0, -1.3, "tc", "top view") ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          th = -90*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.17*Math.cos(th), 1.17*Math.sin(th), "cc", "$X$") ;
          th = (-90+90)*Math.PI/180.0 ;
          fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          fTeXlabel(1.2*Math.cos(th), 1.2*Math.sin(th), "cc", "$Y$") ;
     }
}
