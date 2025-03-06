package com.example.zzyzzy.semiprojectv1.service;

import com.example.zzyzzy.semiprojectv1.domain.*;
import com.example.zzyzzy.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardMapper;
    @Value("${board.page-size}") private int pageSize;


    @Override
    public BoardListDTO readBoard(int cpg) {
        // cpg에 따라 시작위치값 계산
        int stnum = (cpg - 1) * pageSize;
        int totalItems = boardMapper.countBoard();
        List<BoardDTO> boards = boardMapper.selectBoard(stnum, pageSize);


        return new BoardListDTO(cpg, totalItems, pageSize, boards);
    }

    @Transactional
    @Override
    public BoardReplyDTO readOneBoardReply(int bno) {
        boardMapper.updateViewOne(bno);
        Board bd = boardMapper.selectOneBoard(bno);
        List<Reply> rps = boardMapper.selectReply(bno);

        return new BoardReplyDTO(bd,rps);
    }

    @Override
    public List<BoardDTO> findBoard(int cpg, String findtype, String findkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("stnum", (cpg - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("findtype", findtype);
        params.put("findkey", findkey);

        return boardMapper.selectFindBoard(params);
    }

    @Override
    public int countfindBoard(String findtype, String findkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("pageSize", pageSize);
        params.put("findtype", findtype);
        params.put("findkey", findkey);

        return boardMapper.countFindBoard(params);
    }

//    @Override
//    public Board readOneBoard(int bno) {
//        return boardMapper.selectOneBoard(bno);
//
//    }

//    @Override
//    public void readOneView(int bno) {
//        boardMapper.updateViewOne(bno);
//    }

    @Override
    public boolean newBoard(NewBoardDTO newboardDTO) {
        int result = boardMapper.insertBoard(newboardDTO);
        return result > 0;
    }

    @Override
    public boolean newReply(NewReplyDTO newreplyDTO) {
        int result = boardMapper.insertReply(newreplyDTO);
        return result > 0;
    }

//    @Override
//    public List<Reply> readReply(int pno) {
//        return boardMapper.selectReply(pno);
//    }

    @Override
    public boolean newComment(NewReplyDTO newreplyDTO) {
        int result = boardMapper.insertComment(newreplyDTO);
        return result > 0;
    }
}
