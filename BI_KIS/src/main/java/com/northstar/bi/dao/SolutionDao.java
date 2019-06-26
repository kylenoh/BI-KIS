package com.northstar.bi.dao;

import java.util.List;

import com.northstar.bi.dto.Solution;
import com.northstar.bi.dto.SolutionCriteria;
import com.northstar.bi.dto.SolutionFile;
import com.northstar.bi.dto.SolutionReply;

public interface SolutionDao {
////	LIST	
//	Insert
	void insertSolution(Solution solution);
//	Select
	int getTotalRows (SolutionCriteria criteria);
	List<Solution> getSolutionList (SolutionCriteria criteria);
	Solution getSolutionByNo (int no);
//	Update
	void updateSolution(Solution solution);
//	Delete
	void deleteSolution(int no);

	
////	File
//	Insert
	void insertSolutionFile(SolutionFile solutionfile);
//	SelectFile
	List<SolutionFile> getFileList();
	SolutionFile getFileByNo(int no);
	SolutionFile getFile(int no);
//	Update
	void deleteSolutionFileList(int solutionNo);
	void updateSolutionFile(int fileNo);
//	DeleteFile
	SolutionFile deleteFile (int no);
//	Download
	SolutionFile selectDownload(int no);
	
////	Reply
//	Insert
	void insertSolutionReply(SolutionReply reply);
//	Select
	List<SolutionReply> getSolutionReplybyNo (int no);
//	Delete
	void deleteSolutionReply(int no);
}
