package edu.jhu.jacana.align.feature

import edu.jhu.jacana.align.AlignPair
import edu.jhu.jacana.align.AlignFeatureVector
import edu.jhu.jacana.align.resource.GizaReversePTable
//import edu.jhu.jacana.align.resource.GizaAlign
import edu.jhu.jacana.align.IndexLabelAlphabet.NONE_STATE
import edu.jhu.jacana.align.Alphabet
import edu.jhu.jacana.align.util.AlignerParams

object GIZAReverseAlignFeature extends AlignFeature {
    
    val FEAT_NAME = "gizaR"

    override def init() { 
        // fireup PPDB the first time
        GizaReversePTable.prob("a", "a")
        //GizaAlign.isAligned("train0", 0, 0)
    }
    
 	def addPhraseBasedFeature(pair: AlignPair, ins:AlignFeatureVector, i:Int, srcSpan:Int, j:Int, tgtSpan:Int, currState:Int, featureAlphabet: Alphabet) {
 		if (j == -1) {
		} else {
		    if (!AlignerParams.phraseBased) {
		    	if (srcSpan == 1 && tgtSpan == 1)
            //ins.addFeature(FEAT_NAME, NONE_STATE, currState, GizaAlign.isAligned(pair.id, i, j), srcSpan, featureAlphabet)
		    		ins.addFeature(FEAT_NAME, NONE_STATE, currState, GizaReversePTable.prob(pair.tgtTokens(j), pair.srcTokens(i)), srcSpan, featureAlphabet)
		      }
		}
	
	}
}
