package net.javaguides.springboot.model;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String content;

  public Greeting(){}

  public Greeting(String content) {
    this.content = content;

    }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Greeting{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content);
        sb.append('}');
        return sb.toString();
    }

}