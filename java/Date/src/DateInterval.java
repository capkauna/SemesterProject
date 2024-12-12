public class DateInterval
{
  private Date start;
  private Date end;

  public DateInterval(Date start, Date end)
  {
    if(!isValidInterval(start, end))
    {
      throw new IllegalArgumentException("Start date must be before or the same as end date");
    }
    this.start = start;
    this.end = end;
  }

  public Date getStart()
  {
    return start;
  }

  public void setStart(Date start)
  {
    this.start = start;
  }

  public Date getEnd()
  {
    return end;
  }

  public void setEnd(Date end)
  {
    this.end = end;
  }

  private boolean isValidInterval(Date start, Date end)
  {
    return !start.isAfter(end);
  }

  









}
