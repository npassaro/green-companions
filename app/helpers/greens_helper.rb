module GreensHelper
  def array_of_abreviated_months
    I18n.t('date.abbr_month_names')
      .compact
      .map
      .with_index { |name, i| [ i, name ]  }
  end

  def period_to_string(period)
    period
      .compact
      .map {|m| first_letter_month(m) }
      .join('')
  end

  private
    def first_letter_month(month)
      I18n.t('date.month_names')[month][0]
    end
end
