package fanstival.domain;

import java.util.Date;

public class Board {
    private String board_id;
    private String writer;
    private String title;
    private String content;
    private Date regdate;
    private Date updatedate;
    private Date deletedate;

    public String getBoard_id(){return board_id;}
    public String getWriter(){return writer;}
    public String getTitle(){return title;}
    public String getContent(){return content;}
    public Date getRegdate(){return regdate;}
    public Date getUpdatedate(){return updatedate;}
    public Date getDeletedate(){return deletedate;}

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }

    public Board(String board_id, String writer, String title, String content, Date regdate, Date updatedate, Date deletedate) {
        this.board_id = board_id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
        this.updatedate = updatedate;
        this.deletedate = deletedate;
    }//생성자 생성한거임.

    @Override
    public String toString() {
        return "Review{" +
                "board_id='" + board_id + '\'' +
                ", writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", updatedate=" + updatedate +
                ", deletedate=" + deletedate +
                '}';
    }
}
