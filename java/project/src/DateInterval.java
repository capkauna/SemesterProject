import Pets.Date;

import java.util.Objects;

public class DateInterval
{
  private Date startDate;
  private Date endDate;

  public DateInterval(Date startDate, Date endDate)
  {
    if(!isValidInterval(startDate, endDate))
    {
      throw new IllegalArgumentException("Start date must be before or the same as end date");
    }
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  private boolean isValidInterval(Date startDate, Date endDate)
  {
    return !startDate.isAfter(endDate);
  }

  public boolean contains (Date date)
  {
    return (date.isAfter(startDate) || date.isEqual(startDate) && date.isBefore(
        endDate) || date.isEqual(endDate));
  }

  public boolean overlaps (DateInterval other)
  {
    return this.contains(other.startDate) || this.contains(other.endDate) || other.contains(this.startDate) || other.contains(this.endDate);
  }

  public int numberOfDays()
  {
    return endDate.toDays() - startDate.toDays();
  }

  @Override
  public String toString()
  {
    return "Booked from " + startDate + " until " + endDate + '.';
  }

  @Override public boolean equals(Object o)
  {
    if (o == null || getClass() != o.getClass())
      return false;
    DateInterval that = (DateInterval) o;
    return Objects.equals(getStartDate(), that.getStartDate())
        && Objects.equals(getEndDate(), that.getEndDate());
  }

  @Override public int hashCode()
  {
    return Objects.hash(getStartDate(), getEndDate());
  }
}
