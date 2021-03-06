package edu.intech.series.model;

import javax.persistence.*;

@Entity
@Table(name = "Episode")
@NamedQueries({
		@NamedQuery(name = "Episode.findAll", query = "SELECT e FROM Episode e"),
		@NamedQuery(name = "Episode.findBySeries",
				query = "SELECT e FROM Season seas, IN(seas.episodes) e WHERE seas.id = :id")
})

public class Episode {

	private int id = -1;
	private final String title;
	private final int number;
	private boolean seen = false;

	/**
	 * @param title
	 * @param number
	 */
	public Episode(final String title, final int number) {
		this.title = title;
		this.number = number;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	@Column(name = "title")
	public final String getTitle() {
		return this.title;
	}

	/**
	 * @return the number
	 */
	@Column(name = "number")
	public final int getNumber() {
		return this.number;
	}

	/**
	 * @return the seen
	 */
	@Column(name = "seen")
	public final boolean isSeen() {
		return this.seen;
	}

	/**
	 * @param seen the seen to set
	 */
	public final void setSeen(final boolean seen) {
		this.seen = seen;
	}

	@Override
	public String toString() {
		return getTitle();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Episode)) {
			return false;
		}
		return ((Episode) obj).getId() == getId();
	}

}
