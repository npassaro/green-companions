module GreensHelper
  def array_of_abreviated_months
    I18n.t('date.abbr_month_names')
      .compact
      .map
      .with_index { |name, i| [ i, name ]  }
  end
end
