#! /usr/bin/perl

my $text = do { local $/; <STDIN> };

my $foot = "";
my $head = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";


#################
#################

sub fix_mathsmode {
  my $n;
  $text =~ s/</ \\lt /g;
  $text =~ s/>/ \\gt /g;
  $text =~ s/\\nicefrac/\\frac/g;


  $text =~ s/\\\$/MYDOLLAR/g; #careful of \$ over just $

  $text =~ s/\$\$/DolDol/g; #replacing displaymath $$

  $text =~ s{DolDol}{++$n % 2 ? "<me>" : "<\/me>"}ge;
  $text =~ s{\$}{++$n % 2 ? "<m>" : "<\/m>"}ge;


  $text =~ s/MYDOLLAR/\\\$/g;

  $text =~ s/\\begin\{equation\*}/<me>/g;
  $text =~ s/\\end\{equation\*}/<\/me>/g;

  $text =~ s/\\\[/<me>\n/g;
  $text =~ s/\\\]/<\/me>\n/g;
}

sub fix_env_simple {
  my $be="\\begin{$_[0]}";
  my $ee="\\end{$_[0]}";
  my $br="<$_[1]>";
  my $er="<\/$_[1]>";

  $text =~ s/\Q$be\E\[(.+?)\]/$br\E<title>\1<\/title>/g;
  $text =~ s/\Q$be/$br/g;
  $text =~ s/\Q$ee/$er/g;
}

sub fix_env_psimple {
  my $be="\\begin{$_[0]}";
  my $ee="\\end{$_[0]}";
  my $br="</p>\n<$_[1]>";
  my $er="<\/$_[1]>\n<p>";

  $text =~ s/\Q$be\E\[(.+?)\]/$br\E<title>\1<\/title>/g;
  $text =~ s/\Q$be/$br/g;
  $text =~ s/\Q$ee/$er/g;
}

sub fix_env_simple_p {
  my $be="\\begin{$_[0]}";
  my $ee="\\end{$_[0]}";
  my $br="<$_[1]>";
  my $er="</p><\/$_[1]>";

  $text =~ s/\Q$be\E\[(.+?)\]/$br\E<title>\1<\/title>\n<p>/g;
  $text =~ s/\Q$be\E\{(.+?)\}/$br\E<title>\1<\/title>\n<p>/g;   ##needed for proofs.
  $text =~ s/\Q$be/$br\n<p>/g;
  $text =~ s/\Q$ee/$er/g;
}

sub fix_env_simple_sp {
  my $be="\\begin{$_[0]}";
  my $ee="\\end{$_[0]}";
  my $br="<$_[1]>";
  my $er="</p></statement>\n<\/$_[1]>";

  $text =~ s/\Q$be\E\[(.+?)\]/$br\E<title>\1<\/title>\n<statement><p>/g;
  $text =~ s/\Q$be/$br\n<statement><p>/g;
  $text =~ s/\Q$ee/$er/g;
}

sub remove_env {
  my $be="\\begin{$_[0]}";
  my $ee="\\end{$_[0]}";
  $text =~ s/\Q$be\E\s*//g;
  $text =~ s/\Q$ee\E\s*//g;
}

sub misc_replacements {
  ## replace \dots with <ellipsis/>
  $text =~ s/\\dots/<ellipsis\/>/g;
  ## replace \dots with <mdash/>
  $text =~ s/\-\-\-/<mdash\/>/g;
  ## replace & with &amp;
  $text =~s/\&/\&amp\;/g;
  ## replace ~ with <nbsp/>
  $text =~s/~/<nbsp\/>/g;

  ## replace quotation marks `` and '' by <q> and </q> respectively
  $text =~ s/\`\`/<q>/g;
  $text =~ s/''/<\/q>/g;
  $text =~ s/\"/<\/q>/g; ## for problem sets

  ## replace caption
  $text =~ s/\\caption\{(.+?)\}/<caption>\1<\/caption>/sg;
  ## replace textbf
  $text =~ s/\\textbf\{(.+?)\}/<alert>\1<\/alert>/sg;
  ## replace emph
  $text =~ s/\\emph\{(.+?)\}/<em>\1<\/em>/sg;

  ## replace intertext
  $text =~ s/\\intertext\{(.+?)\}/<\/mrow>\n<intertext>\1<\/intertext><mrow>/sg;

  ## replace ref and change space and : and . to _
  $text =~ (s:\\ref\*?\{[^\}]*\}:($x=$&)=~s/[ ,\:,\.]/_/g;$x:ge);  #also handle \ref*
  $text =~ s/\\ref\*?\{(.+?)\}/<xref ref=\"\1\"\/>/sg;

  ## replace eqref and change space and : and . to _
  $text =~ (s:\\eqref\{[^\}]*\}:($x=$&)=~s/[ ,\:,\.]/_/g;$x:ge);
  $text =~ s/\\eqref\{(.+?)\}/<xref ref=\"\1\"\/>/sg;

  ## replace eref{CLP101} and change space and : and . to _
  $text =~ (s:\\eref\{CLP101\}\{[^\}]*\}:($x=$&)=~s/[ ,\:,\.]/_/g;$x:ge);
  $text =~ s/\\eref\{CLP101\}\{(.+?)\}/<xref ref=\"\1\"\/>/sg;

  ## replace label and change space and : and . to _
  $text =~ (s:\\label\{[^\}]*\}:($x=$&)=~s/[ ,\:,\.]/_/g;$x:ge);
  $text =~ s/\\label\{(.+?)\}/xml:id=\"\1\"/sg;
  ## delete newlines between the quotes. --- see http://www.unix.com/shell-programming-and-scripting/127265-how-substitute-value-double-quotes-perl.html
  $text =~ s/(?<==")([^"]*)(?=")/($x = $1) =~ s|\r\n||g;$x/ge;

  ## replace footnote = do after fixing refs so that ref inside footnote is okay.
  $text =~ s/\\footnote\{(.+?)\}/\n<fn>\1<\/fn>\n/sg;


  ## replace \includegraphics[X]{Y} with <image source="Y"/>
  $text =~ s/\\includegraphics\[(.+?)\]\{(.+?)\}/<image source=\"problems\/figs\/\2"\/>/sg;
  $text =~ s/\\includegraphics\{(.+?)\}/<image source=\"problems\/figs\/\1"\/>/sg;

  ## replace \section{blah} with <section><title>blah</title>\n<introduction>
#  if(  $text =~ s/\\section\{(.+?)\}/<section xmlns:xi=\"http:\/\/www.w3.org\/2001\/XInclude\">\n<title>\1<\/title>\n<introduction>\n\n/sg ) {
#   $foot = "\n\n<\/introduction>\n<\/section>\n" . $foot;
#  }

  ## replace \chapter{blah} with <chapter><title>blah</title>\n<introduction>
  if( $text =~ s/\\chapter\{(.+?)\}/<chapter xmlns:xi=\"http:\/\/www.w3.org\/2001\/XInclude\">\n<title>\1<\/title>\n<introduction>\n\n/sg ) {
    $foot = "\n\n<\/introduction>\n<\/chapter>\n" . $foot;
  }

  ## replace \subsection{blah} with <subsection><title>blah</title>\n
 # $text =~ s/\\subsection\{(.+?)\}/<subsection>\n<title>\1<\/title>\n/sg;
 # $text =~ s/\\subsection\*\{(.+?)\}/<subsection>\n<title>\1<\/title>\n/sg;
}

sub fix_itemize {
# #replace itemize,description with <ul> and enumerate with <ol>
  $text =~ s/\\begin\{itemize\}/<ul>/g;
  $text =~ s/\\end\{itemize\}/<\/li>\n<\/ul>/g;

  $text =~ s/\\begin\{description\}/<ul>/g;
  $text =~ s/\\end\{description\}/<\/li>\n<\/ul>/g;

  $text =~ s/\\begin\{enumerate\}/<ol>/g;
  $text =~ s/\\end\{enumerate\}/<\/li>\n<\/ol>/g;


  $text =~ s/\\item/<\/li>\n<li>/g;  #but now our list starts with <ul>\n</li> - need to delete that.
  $text =~ s/<ul>\s*<\/li>/<ul>/sg;
  $text =~ s/<ol>\s*<\/li>/<ol>/sg;
  $text =~ s/\s*<\/li>/\n<\/li>/g;  ## clean up whitespace before </li>

  $text =~ s/<ol>\[\(a\)\]\n<\/li>/<ol typeAAA>/sg;  # fix up itemized list with alphabetic. #fix typeAAA=>type="a" shortly.
}

sub fix_align_env {
  $text =~ s/\\begin\{align\*\}/BBBB/g;
  $text =~ s/\\end\{align\*\}/EEEE/g;

  my @tmp;
  for(split /\n/, $text) {
    if(/BBBB/../EEEE/){
      s/\\\\/\n<\/mrow><mrow>/;
      s/BBBB/<md>\n<mrow>/;
      s/EEEE/<\/mrow>\n<\/md>/;
    }
    push(@tmp, $_);
  }
  $text = join("\n",@tmp);
  # perl -e 'while (<>){if(/BBB/../EEE/){ s/\\\\/<\/mrow>\n<mrow>/; s/BBB/<md>\n<mrow>/; s/EEE/<\/mrow>\n<\/md>/; print $_; } else{print $_};}' $TFN > tmp
  ## solution from here http://www.perlmonks.org/?node_id=979946 and http://www.perlmonks.org/?node_id=745018
}

sub fix_alignat_env {
  $text =~ s/\\begin\{alignat\*\}/BBBB/g;
  $text =~ s/\\end\{alignat\*\}/EEEE/g;

  my @tmp;
  for(split /\n/, $text) {
    if(/BBBB/../EEEE/){
      s/\\\\/\n<\/mrow><mrow>/;
      s/BBBB/<md alignment="alignat">\n<mrow>/;
      s/EEEE/<\/mrow>\n<\/md>/;
    }
    push(@tmp, $_);
  }
  $text = join("\n",@tmp);
  # perl -e 'while (<>){if(/BBB/../EEE/){ s/\\\\/<\/mrow>\n<mrow>/; s/BBB/<md>\n<mrow>/; s/EEE/<\/mrow>\n<\/md>/; print $_; } else{print $_};}' $TFN > tmp
  ## solution from here http://www.perlmonks.org/?node_id=979946 and http://www.perlmonks.org/?node_id=745018
}

sub fix_tabular_env {
  $text =~ s/\\begin\{tabular\}/BBBB/g;
  $text =~ s/\\end\{tabular\}/EEEE/g;

  my @tmp;
  for(split /\n/, $text) {
    if(/BBBB/../EEEE/){
      s/\\\\/<\/cell>\n<\/row><row>\n<cell>/;
      s/\&amp;/<\/cell><cell>/g;
      s/BBBB/<tabular>\n<row>\n<cell>/;
      s/EEEE/<\/row>\n<\/tabular>/;
    }
    push(@tmp, $_);
  }
  $text = join("\n",@tmp);
}

sub fix_paragraphing {
  $text =~ s/\n\s*\n+/\n<\/p>\n\n<p>/sg;
  # also remove and <p>whitespace</p>
  $text =~ s/<p>\s*<\/p>//sg;

}


sub fix_tikz {
  $text =~ s/\\begin\{tikzpicture\}/<\/p><sidebyside>\n<image><latex-image-code><!\[CDATA\[\\begin{tikzpicture}/g;
  $text =~ s/\\end\{tikzpicture\}/\\end\{tikzpicture\}ENDDATA\]\]><\/latex-image-code><\/image>\n<\/sidebyside><p>/g;
  # now fix any <m> and </m> between CDATA and ENDDATA back into $.

  my @tmp;
  for(split /\n/, $text) {
    if(/CDATA/../ENDDATA/){
      s/<m>/\$/g;
      s/<\/m>/\$/g;
    }
    push(@tmp, $_);
  }
  $text = join("\n",@tmp);
  $text =~s/ENDDATA//g;
}

#################
#################

sub make_exercises {
	$text =~ s/\\subsection\*\{\\Conceptual\}/<exercises>\n\n<exercisegroup><introduction><conceptual\/><\/introduction>\n/g;
	$text =~ s/\\subsection\*\{\\Procedural\}/<\/exercise>\n<\/exercisegroup>\n\n<exercisegroup><introduction><procedural\/><\/introduction>\n/g;
	$text =~ s/\\subsection\*\{\\Application\}/<\/exercise>\n<\/exercisegroup>\n\n<exercisegroup><introduction><application\/><\/introduction>\n/g;

	$text =~ s/\\begin\{question\}\[(.+?)\]/<exercise><title><fromexam>\1<\/fromexam><\/title>\n<statement><p>\n<p>/g;
	$text =~ s/\\begin\{question\}/<exercise>\n<statement><p>/g;
	$text =~ s/\\begin\{Mquestion\}\[(.+?)\]/<exercise><title>\[RQS\]<fromexam>\1<\/fromexam><\/title>\n<statement><p>\n<p>/g;
	$text =~ s/\\begin\{Mquestion\}/<exercise><title>\[RQS\]<\/title>\n<statement><p>/g;
	$text =~ s/\\end\{.?question\}/<\/p><\/statement>/g;
	$text =~ s/\\begin\{answer\}/<answer><p>/g;
	$text =~ s/\\begin\{hint\}/<hint><p>/g;
	$text =~ s/\\begin\{solution\}/<solution><p>/g;
	$text =~ s/\\end\{answer\}/<\/p><\/answer>/g;
	$text =~ s/\\end\{hint\}/<\/p><\/hint>/g;
	$text =~ s/\\end\{solution\}/<\/p><\/solution>\n<\/exercise>/g;

	$text =~ s/tion>\n*<\/exe/tion>\n<\/exe/sg;

	$text =~ s/\\Instructions\{(.+?)\}/<introduction><p>\1<\/p><\/introduction>/sg;


	$foot = "<\/exercisegroup>\n\n<\/exercises>\n" . $foot;

}

sub fix_final() {
	$text =~ s/typeAAA/label\=\"a\"/sg;
	$text =~ s/tion>\s*<\/p>\s*<p>\s*<\/exe/tion>\n<\/exe/sg;
	$text =~ s/<p>\s*<p>/<p>/sg;
	$text =~ s/<\/exercise>\n<exercise>/<\/exercise>\n\n<exercise>/sg;
	$text =~ s/<\/exercise>\n*<\/p>\n*<p><\/exercise>/<\/exercise>/sg;
	$text =~ s/<\/exercise>\n<\/p>\n\n<p><exercise>/<\/exercise>\n\n<exercise>/sg;

	$text =~ s/<\/statement>\n*<\/p>\n*<p>/<\/statement>\n\n/sg;
	$text =~ s/<\/hint>\n*<\/p>\n*<p>/<\/hint>\n\n/sg;
	$text =~ s/<\/answer>\n*<\/p>\n*<p>/<\/answer>\n\n/sg;
}

#################
#################

## Delete any text from % to newline ---  A big hack.
## but be careful to not delete \%
$text =~ s/\\%/MYPERCENT/g;
$text =~ s/%(.*)\n/\n/g;
$text =~ s/MYPERCENT/\\%/g;

## Fix $ blah $ -> <m> blah </m> and < and > to \lt and \gt
fix_mathsmode();

## Fix tikz.
fix_tikz();

## replace fig with sidebyside, and figure with figure

fix_env_psimple("fig","sidebyside");
fix_env_psimple("efig","sidebyside");
fix_env_psimple("nfig","sidebyside");
fix_env_psimple("sfig","sidebyside");
fix_env_psimple("wfig","sidebyside");
fix_env_simple("figure","figure");

## replace quote with blockquote and p
fix_env_simple_p("quote","blockquote");
## similarly with example
fix_env_simple_p("eg","example");
## similarly with proof
fix_env_simple_p("proof","proof");

## replace defn with definition and statement and p
fix_env_simple_sp("defn", "definition");
fix_env_simple_sp("notn", "definition"); ## really want a notation env.
fix_env_simple_sp("lemma", "lemma");
fix_env_simple_sp("theorem", "theorem");
fix_env_simple_sp("cor", "corollary");
fix_env_simple_sp("result", "proposition");

## replace itemize with ul and enumerate with ol
fix_itemize();

## misc replacements
misc_replacements();

## replace align* with <md>
fix_align_env();
fix_alignat_env();
fix_tabular_env();

## remove center env
remove_env("center");

## Make exercises
make_exercises();


## fix multiple newlines and add paragraphing (very hack)
fix_paragraphing();

## fix final things
fix_final();

## print things.

print $head;
print $text;
print $foot;
#
