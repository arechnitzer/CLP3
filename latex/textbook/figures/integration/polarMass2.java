                  /*  File:  polarMass2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarMass2 extends Template {

     static {templateClass = new polarMass2() ; }

     public void setup() {
          filePrefix = "polarMass2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;      // in inches
          ysize = 1.8 ;   // in inches
          xmin = -1 ;
          xmax = 6 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0.1 ;   // in inches
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
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          double a = Math.PI/12 ;
          double b = Math.PI/2.5 ;

          double dth  = (b-a)/4 ;
//          double th1 = a+ dth ;
//          double th2 = a+ 2*dth ;
          double th1 = a ;
          double th2 = b ;
          double thm = 0.5*th1+0.5*th2 ;
          double x1 = (3+2*Math.sin(th1))*Math.cos(th1);
          double y1 = (3+2*Math.sin(th1))*Math.sin(th1);
          double x2 = (3+2*Math.sin(th2))*Math.cos(th2);
          double y2 = (3+2*Math.sin(th2))*Math.sin(th2);
          double xm = (3+2*Math.sin(thm))*Math.cos(thm);
          double ym = (3+2*Math.sin(thm))*Math.sin(thm);
          fEnv("psFillGray", 0.9) ;
          {double[] xlist = {0, x1, xm, x2} ;
           double[] ylist = {0, y1, ym, y2} ;
           fPolygon(xlist, ylist, 4, FILLED) ;}
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  th1, th2, FILLED);
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  th1/2, 1.4*th2, OPEN);

          double phi1 = 40*Math.PI/180.0 ;
          double phi2 = 50*Math.PI/180.0 ;
          double phim = 0.5*phi1+0.5*phi2 ;
          double X1 = (3+2*Math.sin(phi1))*Math.cos(phi1);
          double Y1 = (3+2*Math.sin(phi1))*Math.sin(phi1);
          double X2 = (3+2*Math.sin(phi2))*Math.cos(phi2);
          double Y2 = (3+2*Math.sin(phi2))*Math.sin(phi2);
          double Xm = (3+2*Math.sin(phim))*Math.cos(phim);
          double Ym = (3+2*Math.sin(phim))*Math.sin(phim);
          fEnv("psFillGray", 0.7) ;
          {double[] xlist = {0, X1, Xm, X2} ;
           double[] ylist = {0, Y1, Ym, Y2} ;
           fPolygon(xlist, ylist, 4, FILLED) ;}
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  phi1, phi2, FILLED);


          x1 = (2-Math.sin(th1))*Math.cos(th1);
          y1 = (2-Math.sin(th1))*Math.sin(th1);
          x2 = (2-Math.sin(th2))*Math.cos(th2);
          y2 = (2-Math.sin(th2))*Math.sin(th2);
          xm = (2-Math.sin(thm))*Math.cos(thm);
          ym = (2-Math.sin(thm))*Math.sin(thm);
          fEnv("psFillGray", 1.0) ;
          {double[] xlist = {0, x1, xm, x2} ;
           double[] ylist = {0, y1, ym, y2} ;
           fPolygon(xlist, ylist, 4, FILLED) ;}
          fCurve("[(2-sin(t))*cos(t),(2-sin(t))*sin(t)]", 1,
                  th1, th2, FILLED);
          fCurve("[(2-sin(t))*cos(t),(2-sin(t))*sin(t)]", 1,
                  th1/2, 1.5*th2, OPEN);

          fEnv("lineWidth", 0.5) ;
          fLine(0,0, 6*Math.cos(a),  6*Math.sin(a)) ;
          fLine(0,0, 6*Math.cos(b),  6*Math.sin(b)) ;
          fLine(0,0, 6*Math.cos(phi1),  6*Math.sin(phi1)) ;
          fLine(0,0, 6*Math.cos(phi2),  6*Math.sin(phi2)) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  a, b, OPEN);
          fCurve("[(2-sin(t))*cos(t),(2-sin(t))*sin(t)]", 1,
                  a, b, OPEN);
          fLine((2-Math.sin(a))*Math.cos(a),(2-Math.sin(a))*Math.sin(a),                   
                   (3+2*Math.sin(a))*Math.cos(a),(3+2*Math.sin(a))*Math.sin(a)) ;
          fLine((2-Math.sin(b))*Math.cos(b),(2-Math.sin(b))*Math.sin(b),
                   (3+2*Math.sin(b))*Math.cos(b),(3+2*Math.sin(b))*Math.sin(b)) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  phi1, phi2, OPEN);
          fCurve("[(2-sin(t))*cos(t),(2-sin(t))*sin(t)]", 1,
                  phi1, phi2, OPEN);
          fLine((2-Math.sin(phi1))*Math.cos(phi1),(2-Math.sin(phi1))*Math.sin(phi1),       
               (3+2*Math.sin(phi1))*Math.cos(phi1),(3+2*Math.sin(phi1))*Math.sin(phi1)) ;
          fLine((2-Math.sin(phi2))*Math.cos(phi2),(2-Math.sin(phi2))*Math.sin(phi2),
               (3+2*Math.sin(phi2))*Math.cos(phi2),(3+2*Math.sin(phi2))*Math.sin(phi2)) ;

          canvas.append( new fPsWrite(Black+"\n")) ;


          double ab2 = 0.5*a + 0.5*b ;
          fTeXlabel(6*Math.cos(a)+0.1,  6*Math.sin(a), "bl", "$\\theta=a$") ;
          fTeXlabel(6*Math.cos(b),  6*Math.sin(b)+0.1, "bc", "$\\theta=b$") ;
          fTeXlabel(6*Math.cos(phi1)+0.1,  6*Math.sin(phi1), "cl", 
                                          "$\\scriptstyle\\theta$") ;
          fTeXlabel(6*Math.cos(phi2)+0.2,  6*Math.sin(phi2)+0.1, "bc", 
                                          "$\\scriptstyle\\theta+\\dee{\\theta}$") ;
          fTeXlabel(4.85*Math.cos(1.42*th2),  4.85*Math.sin(1.42*th2), "cr", 
                                                            "$r=T(\\theta)$") ;
          fTeXlabel(1.1*Math.cos(1.52*th2),  1.1*Math.sin(1.52*th2), "cr", 
                                                             "$r=B(\\theta)$") ;
//          fTeXlabel(3*Math.cos(ab2),  3*Math.sin(ab2), "cc", 
//                                                             "$\\cR$") ;

     }
}
